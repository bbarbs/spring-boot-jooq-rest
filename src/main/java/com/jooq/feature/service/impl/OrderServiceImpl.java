package com.jooq.feature.service.impl;

import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.exception.ItemNotFoundException;
import com.jooq.feature.exception.OrderNotFoundException;
import com.jooq.feature.model.domain.OrderItem;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.repository.ItemOrderRepository;
import com.jooq.feature.repository.ItemRepository;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.feature.service.ItemService;
import com.jooq.feature.service.OrderService;
import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.pojos.ItemsOrders;
import com.jooq.my_schema.tables.pojos.Orders;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;
import com.jooq.my_schema.tables.records.ItemsRecord;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService, ItemService {

    @Autowired
    ItemOrderRepository itemOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Items> getAllItems() {
        List<Items> items = new ArrayList<>();
        List<ItemsRecord> records = this.itemRepository.findAll();
        records.stream()
                .forEach(itemsRecord -> items.add(itemsRecord.into(Items.class)));
        return items;
    }

    @Override
    public Items addItem(Items items) {
        return this.itemRepository.save(items).into(Items.class);
    }

    @Override
    public List<Items> getItemsByOrderId(Long orderId) {
        OrdersRecord record = this.orderRepository.findOne(orderId);
        if (record == null) {
            throw new OrderNotFoundException("Order not found");
        }
        List<Items> list = new ArrayList<>();
        List<ItemsRecord> items = this.itemRepository.getItemsByOrderId(orderId);
        items.stream()
                .forEach(itemsRecord -> list.add(itemsRecord.into(Items.class)));
        return list;
    }

    @Override
    public Orders addCustomerOrder(Long customerId, Orders orders, List<Long> itemIds) {
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Get list of items.
        List<ItemsRecord> itemsRecords = new ArrayList<>();
        for (Long id : itemIds) {
            ItemsRecord itemsRecord = this.itemRepository.findOne(id);
            if (itemsRecord == null) {
                throw new ItemNotFoundException("Item not found");
            }
            itemsRecords.add(itemsRecord);
        }
        // Add customer id.
        orders.setFkCustId(customerRecord.getId());
        // Add to order table.
        OrdersRecord ordersRecord = this.orderRepository.save(orders);
        // Add order to item order table.
        for (ItemsRecord itemsRecord : itemsRecords) {
            ItemsOrdersRecord itemsOrdersRecord = new ItemsOrdersRecord();
            itemsOrdersRecord.setOrderId(ordersRecord.getId());
            itemsOrdersRecord.setItemId(itemsRecord.getId());
            this.itemOrderRepository.save(itemsOrdersRecord.into(ItemsOrders.class));
        }
        return ordersRecord.into(Orders.class);
    }

    @Override
    public List<OrderItem> getAllOrders() {
        List<OrdersRecord> records = this.orderRepository.findAll();
        return this.mapItemsByOrder(records);
    }

    @Override
    public OrderItem getOrderById(Long orderId) {
        OrdersRecord record = this.orderRepository.findOne(orderId);
        if (record == null) {
            throw new OrderNotFoundException("Order not found");
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(record.into(Orders.class));
        List<Items> items = this.getItemsByOrderId(Long.valueOf(record.getId()));
        orderItem.setItems(items);
        return orderItem;
    }

    @Override
    public List<OrderItem> getOrdersByCustomerId(Long customerId) {
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<OrdersRecord> records = this.orderRepository.getOrdersByCustomerId(customerId);
        return this.mapItemsByOrder(records);
    }

    @Override
    public List<OrderItem> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status) {
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<OrdersRecord> records = this.orderRepository.getCustomerOrderByStatus(customerId, status);
        return this.mapItemsByOrder(records);
    }

    @Override
    public List<OrderItem> getOrdersByStatus(OrderStatusEnum status) {
        List<OrdersRecord> records = this.orderRepository.getOrdersByStatus(status);
        return this.mapItemsByOrder(records);
    }

    @Override
    public void removeOrderById(Long orderId) {
        OrdersRecord record = this.orderRepository.findOne(orderId);
        if (record == null) {
            throw new OrderNotFoundException("Order not found");
        }
        this.orderRepository.delete(orderId);
    }

    /**
     * Helper method to map items by order.
     *
     * @param records
     * @return
     */
    private List<OrderItem> mapItemsByOrder(List<OrdersRecord> records) {
        List<OrderItem> list = new ArrayList<>();
        for (OrdersRecord record : records) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(record.into(Orders.class));
            List<Items> items = this.getItemsByOrderId(Long.valueOf(record.getId()));
            orderItem.setItems(items);
            list.add(orderItem);
        }
        return list;
    }
}
