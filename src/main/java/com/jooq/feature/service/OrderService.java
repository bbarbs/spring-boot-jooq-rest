package com.jooq.feature.service;

import com.jooq.feature.model.domain.OrderItem;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.my_schema.tables.pojos.Orders;

import java.util.List;

public interface OrderService {

    /**
     * Add customer order.
     *
     * @param customerId
     * @param orders
     * @param itemIds
     * @return
     */
    Orders addCustomerOrder(Long customerId, Orders orders, List<Long> itemIds);

    /**
     * Get list of orders.
     *
     * @return
     */
    List<OrderItem> getAllOrders();

    /**
     * Get order by id.
     *
     * @param orderId
     * @return
     */
    OrderItem getOrderById(Long orderId);

    /**
     * Get orders by customer.
     *
     * @param customerId
     * @return
     */
    List<OrderItem> getOrdersByCustomerId(Long customerId);

    /**
     * Get customer order by status.
     *
     * @param customerId
     * @param status
     * @return
     */
    List<OrderItem> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);

    /**
     * Get orders by status.
     *
     * @param status
     * @return
     */
    List<OrderItem> getOrdersByStatus(OrderStatusEnum status);

    /**
     * Remove order.
     *
     * @param orderId
     */
    void removeOrderById(Long orderId);
}
