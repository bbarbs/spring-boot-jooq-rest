package com.jooq.feature.repository;

import com.jooq.core.repository.JooqRepository;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.my_schema.tables.pojos.Orders;
import com.jooq.my_schema.tables.records.OrdersRecord;

import java.util.List;

public interface OrderRepository extends JooqRepository<OrdersRecord, Orders, Long> {

    /**
     * Get list of orders by customer.
     *
     * @param customerId
     * @return
     */
    List<OrdersRecord> getOrdersByCustomerId(Long customerId);

    /**
     * Get customer order by status.
     *
     * @param customerId
     * @param status
     * @return
     */
    List<OrdersRecord> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);

    /**
     * Get list of orders by status.
     *
     * @param status
     * @return
     */
    List<OrdersRecord> getOrdersByStatus(OrderStatusEnum status);
}
