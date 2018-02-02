package com.jooq.feature.service;

import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.model.wrapper.CustomerOrderWrapper;
import com.jooq.feature.model.wrapper.OrderResponseWrapper;

import java.util.List;

public interface OrderService {

    OrderResponseWrapper addCustomerOrder(Long customerId, OrderDto orderDto, List<Long> itemIds);

    List<CustomerOrderWrapper> getAllOrders();

    OrderResponseWrapper getOrderById(Long orderId);

    List<OrderResponseWrapper> getOrdersByCustomerId(Long customerId);

    List<OrderResponseWrapper> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);

    List<OrderResponseWrapper> getOrdersByStatus(OrderStatusEnum status);

    List<ItemDto> getItemsByOrderId(Long orderId);

    CustomerDto getCustomerByOrderId(Long orderId);

    void removeOrderById(Long id);
}
