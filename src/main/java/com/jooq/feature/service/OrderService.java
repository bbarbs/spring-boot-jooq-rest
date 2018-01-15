package com.jooq.feature.service;

import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.OrderContext;
import com.jooq.my_schema.tables.records.OrdersRecord;

import java.util.List;

public interface OrderService {

    OrderContext addCustomerOrder(Long customerId, OrderContext context);

    List<OrderContext> getAllOrders();

    OrderContext getOrderById(Long orderId);

    List<OrderContext> getOrdersByCustomerId(Long customerId);

    List<OrderContext> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);
}
