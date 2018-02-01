package com.jooq.feature.service;

import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.CustomerOrderContext;
import com.jooq.feature.model.wrapper.OrderResContext;

import java.util.List;

public interface OrderService {

    OrderResContext addCustomerOrder(Long customerId, OrderDto orderDto, List<Long> itemIds);

    List<CustomerOrderContext> getAllOrders();

    OrderResContext getOrderById(Long orderId);

    List<OrderResContext> getOrdersByCustomerId(Long customerId);

    List<OrderResContext> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);

    List<OrderResContext> getOrdersByStatus(OrderStatusEnum status);

    List<ItemDto> getItemsByOrderId(Long orderId);

    void removeOrderById(Long id);
}
