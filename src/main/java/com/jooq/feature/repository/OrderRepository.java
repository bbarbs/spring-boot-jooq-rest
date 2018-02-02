package com.jooq.feature.repository;

import com.jooq.core.repository.IGenericRepository;
import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.OrdersRecord;

import java.util.List;

public interface OrderRepository extends IGenericRepository<OrdersRecord> {

    boolean exist(Long id);

    List<OrdersRecord> getOrdersByCustomerId(Long customerId);

    List<OrdersRecord> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status);

    List<OrdersRecord> getOrdersByStatus(OrderStatusEnum status);

    CustomerRecord getCustomerByOrderId(Long orderId);
}
