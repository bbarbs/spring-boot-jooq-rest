package com.jooq.feature.service.impl;

import com.jooq.feature.exception.ItemNotFoundException;
import com.jooq.feature.exception.OrderNotFoundException;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.OrderContext;
import com.jooq.feature.repository.ItemOrderRepository;
import com.jooq.feature.repository.ItemRepository;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.feature.service.OrderService;
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
    public OrderContext addCustomerOrder(Long customerId, OrderContext context) throws ItemNotFoundException {
        ItemsRecord itemsRecord = this.itemRepository.findOne(Long.valueOf(context.getItem().getId()));
        if (itemsRecord == null) {
            throw new ItemNotFoundException("Item not found");
        }
        // Add to order table.
        OrdersRecord ordersRecord = new OrdersRecord();
        ordersRecord.setFkCustId(Math.toIntExact(customerId));
        ordersRecord.setDateOrder(new Timestamp(context.getOrder().getDateOrder().getTime()));
        ordersRecord.setStatus(context.getOrder().getStatus().toString());
        ordersRecord.setAmount(context.getOrder().getAmount());
        OrdersRecord addedOrder = this.orderRepository.save(ordersRecord);
        // Add order to item order table.
        ItemsOrdersRecord itemsOrdersRecord = new ItemsOrdersRecord();
        itemsOrdersRecord.setOrderId(addedOrder.getId());
        itemsOrdersRecord.setItemId(itemsRecord.getId());
        this.itemOrderRepository.save(itemsOrdersRecord);
        // Set response.
        OrderContext orderContext = new OrderContext();
        orderContext.setItem(itemsRecord.map(record -> new ItemDto().map((ItemsRecord) record)));
        orderContext.setOrder(addedOrder.map(record -> new OrderDto().map((OrdersRecord) record)));
        return orderContext;
    }

    @Override
    public List<OrderContext> getAllOrders() {
        List<OrdersRecord> ordersRecords = this.orderRepository.findAll();
        List<OrderContext> contexts = new ArrayList<>();
        mapOrderRecordToContextList(ordersRecords, contexts);
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
    public OrderContext getOrderById(Long orderId) throws OrderNotFoundException {
        OrdersRecord ordersRecord = this.orderRepository.findOne(orderId);
        if (ordersRecord == null) {
            throw new OrderNotFoundException("Order not found");
        }
        ItemsOrdersRecord itemsOrdersRecord = this.itemOrderRepository.findOne(orderId);
        ItemsRecord itemsRecord = this.itemRepository.findOne(Long.valueOf(itemsOrdersRecord.getItemId()));
        // Set order context.
        OrderContext context = new OrderContext();
        context.setOrder(ordersRecord.map(record -> new OrderDto().map((OrdersRecord) record)));
        context.setItem(itemsRecord.map(record -> new ItemDto().map((ItemsRecord) record)));
        return context;
    }

    @Override
    public List<OrderContext> getOrdersByCustomerId(Long customerId) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getOrdersByCustomerId(customerId);
        List<OrderContext> contexts = new ArrayList<>();
        mapOrderRecordToContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public List<OrderContext> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getCustomerOrderByStatus(customerId, status);
        List<OrderContext> contexts = new ArrayList<>();
        mapOrderRecordToContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public List<OrderContext> getOrdersByStatus(OrderStatusEnum status) {
        List<OrdersRecord> ordersRecords = this.orderRepository.getOrdersByStatus(status);
        List<OrderContext> contexts = new ArrayList<>();
        mapOrderRecordToContextList(ordersRecords, contexts);
        return contexts;
    }

    @Override
    public void removeOrderById(Long id) throws OrderNotFoundException {
        OrdersRecord record = this.orderRepository.findOne(id);
        if(record == null) {
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
    private void mapOrderRecordToContextList(List<OrdersRecord> ordersRecords, List<OrderContext> contexts) {
        for (OrdersRecord record : ordersRecords) {
            OrderContext context = new OrderContext();
            context.setOrder(record.map(orderRecord -> new OrderDto().map((OrdersRecord) orderRecord)));
            context.setItem(getItemsRecord(Long.valueOf(record.getId())).map(item -> new ItemDto().map((ItemsRecord) item)));
            contexts.add(context);
        }
    }
}
