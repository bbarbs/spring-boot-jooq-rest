package com.jooq.feature.service.impl;

import com.jooq.feature.exception.ItemNotFoundException;
import com.jooq.feature.exception.OrderNotFoundException;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.CustomerOrderContext;
import com.jooq.feature.model.wrapper.OrderResContext;
import com.jooq.feature.repository.ItemOrderRepository;
import com.jooq.feature.repository.ItemRepository;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.feature.service.OrderService;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;
import com.jooq.my_schema.tables.records.ItemsRecord;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Inject
    ItemOrderRepository itemOrderRepository;

    @Inject
    OrderRepository orderRepository;

    @Inject
    ItemRepository itemRepository;

    @Override
    public OrderResContext addCustomerOrder(Long customerId, OrderDto orderDto, List<Long> itemIds) throws ItemNotFoundException {
        // Get list of items.
        List<ItemsRecord> itemsRecords = new ArrayList<>();
        for (Long id : itemIds) {
            ItemsRecord itemsRecord = this.itemRepository.findOne(id);
            if (itemsRecord == null) {
                throw new ItemNotFoundException("Item not found");
            }
            itemsRecords.add(itemsRecord);
        }
        // Add to order table.
        OrdersRecord ordersRecord = new OrdersRecord();
        ordersRecord.setFkCustId(Math.toIntExact(customerId));
        ordersRecord.setDateOrder(new Timestamp(orderDto.getOrderDate().getTime()));
        ordersRecord.setStatus(orderDto.getOrderStatus().toString());
        ordersRecord.setAmount(orderDto.getOrderAmount());
        OrdersRecord addedOrder = this.orderRepository.save(ordersRecord);
        // Add order to item order table.
        for (ItemsRecord itemsRecord : itemsRecords) {
            ItemsOrdersRecord itemsOrdersRecord = new ItemsOrdersRecord();
            itemsOrdersRecord.setOrderId(addedOrder.getId());
            itemsOrdersRecord.setItemId(itemsRecord.getId());
            this.itemOrderRepository.save(itemsOrdersRecord);
        }
        // Set response.
        OrderResContext orderResContext = new OrderResContext();
        // Map item record to dto.
        List<ItemDto> itemDtos = new ArrayList<>();
        itemsRecords.stream().forEach(itemsRecord -> itemDtos.add(itemsRecord.map(record -> new ItemDto().map((ItemsRecord) record))));
        orderResContext.setItems(itemDtos);
        // Add order.
        orderResContext.setOrder(addedOrder.map(record -> new OrderDto().map((OrdersRecord) record)));
        return orderResContext;
    }

    @Override
    public List<CustomerOrderContext> getAllOrders() {
        List<CustomerOrderContext> contexts = new ArrayList<>();
        // Get list of orders.
        List<OrdersRecord> ordersRecords = this.orderRepository.findAll();
        for (OrdersRecord record : ordersRecords) {
            CustomerOrderContext orderContext = new CustomerOrderContext();
            // Add customer.
            CustomerRecord customerRecord = this.orderRepository.getCustomerByOrderId(Long.valueOf(record.getId()));
            orderContext.setCustomer(customerRecord.map(record1 -> new CustomerDto().map((CustomerRecord) record1)));
            // Add order context.
            OrderResContext orderResContext = new OrderResContext();
            orderResContext.setOrder(record.map(record1 -> new OrderDto().map((OrdersRecord) record1)));
            // Order items.
            List<ItemDto> itemDtos = new ArrayList<>();
            List<ItemsRecord> itemsRecords = this.itemOrderRepository.getItemsByOrderId(Long.valueOf(record.getId()));
            itemsRecords.stream()
                    .forEach(itemsRecord -> itemDtos.add(itemsRecord.map(record12 -> new ItemDto().map((ItemsRecord) record12))));
            orderResContext.setItems(itemDtos);
            orderContext.setOrder(orderResContext);
            // Add to context.
            contexts.add(orderContext);
        }
        return contexts;
    }

    /**
     * Get item record.
     *
     * @param orderId
     * @return
     */
    private ItemsRecord getItemsRecord(Long orderId) {
        ItemsOrdersRecord itemsOrdersRecord = this.itemOrderRepository.findOne(orderId);
        return this.itemRepository.findOne(Long.valueOf(itemsOrdersRecord.getItemId()));
    }

    @Override
    public OrderResContext getOrderById(Long orderId) throws OrderNotFoundException {
        OrdersRecord ordersRecord = this.orderRepository.findOne(orderId);
        if (ordersRecord == null) {
            throw new OrderNotFoundException("Order not found");
        }
        // Get list of items on order.
        List<ItemsOrdersRecord> itemsOrdersRecords = this.itemOrderRepository.getItemOrderByOrderId(orderId);
        List<ItemsRecord> itemsRecords = new ArrayList<>();
        for (ItemsOrdersRecord itemsOrdersRecord : itemsOrdersRecords) {
            ItemsRecord itemsRecord = this.itemRepository.findOne(Long.valueOf(itemsOrdersRecord.getItemId()));
            itemsRecords.add(itemsRecord);
        }
        // Set order context.
        OrderResContext context = new OrderResContext();
        context.setOrder(ordersRecord.map(record -> new OrderDto().map((OrdersRecord) record)));
        // Map item record to dto.
        List<ItemDto> itemDtos = new ArrayList<>();
        for (ItemsRecord itemsRecord : itemsRecords) {
            itemDtos.add(itemsRecord.map(record -> new ItemDto().map((ItemsRecord) record)));
        }
        context.setItems(itemDtos);
        return context;
    }

    @Override
    public List<OrderResContext> getOrdersByCustomerId(Long customerId) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getOrdersByCustomerId(customerId);
        List<OrderResContext> contexts = new ArrayList<>();
        mapOrderRecordToOrderResContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public List<OrderResContext> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getCustomerOrderByStatus(customerId, status);
        List<OrderResContext> contexts = new ArrayList<>();
        mapOrderRecordToOrderResContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public List<OrderResContext> getOrdersByStatus(OrderStatusEnum status) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getOrdersByStatus(status);
        List<OrderResContext> contexts = new ArrayList<>();
        mapOrderRecordToOrderResContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public List<ItemDto> getItemsByOrderId(Long orderId) {
        List<ItemDto> itemDtos = new ArrayList<>();
        List<ItemsRecord> itemsRecords = this.itemOrderRepository.getItemsByOrderId(orderId);
        for (ItemsRecord record : itemsRecords) {
            itemDtos.add(record.map(record1 -> new ItemDto().map((ItemsRecord) record1)));
        }
        return itemDtos;
    }

    @Override
    public void removeOrderById(Long id) throws OrderNotFoundException {
        OrdersRecord record = this.orderRepository.findOne(id);
        if (record == null) {
            throw new OrderNotFoundException("Order not found");
        }
        this.orderRepository.deleteById(id);
    }

    /**
     * Add order and item to list.
     *
     * @param ordersRecords
     * @param contexts
     */
    private void mapOrderRecordToOrderResContextList(List<OrdersRecord> ordersRecords, List<OrderResContext> contexts) {
        for (OrdersRecord record : ordersRecords) {
            OrderResContext context = new OrderResContext();
            // Set order dto.
            context.setOrder(record.map(orderRecord -> new OrderDto().map((OrdersRecord) orderRecord)));
            // Get item dto.
            List<ItemDto> itemDtos = new ArrayList<>();
            itemDtos.add(getItemsRecord(Long.valueOf(record.getId())).map(item -> new ItemDto().map((ItemsRecord) item)));
            context.setItems(itemDtos);
            // Add order to context.
            contexts.add(context);
        }
    }
}
