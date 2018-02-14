package com.jooq.feature.repository.impl;

import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.Orders;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<OrdersRecord> getOrdersByCustomerId(Long customerId) {
        return this.dslContext.selectFrom(Tables.ORDERS)
                .where(Tables.ORDERS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .fetch();
    }

    @Override
    public List<OrdersRecord> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status) {
        return this.dslContext.selectFrom(Tables.ORDERS)
                .where(Tables.ORDERS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .and(Tables.ORDERS.STATUS.eq(String.valueOf(status)))
                .fetch();
    }

    @Override
    public List<OrdersRecord> getOrdersByStatus(OrderStatusEnum status) {
        return this.dslContext.selectFrom(Tables.ORDERS)
                .where(Tables.ORDERS.STATUS.eq(String.valueOf(status)))
                .fetch();
    }

    @Override
    public List<OrdersRecord> findAll() {
        return this.dslContext.selectFrom(Tables.ORDERS)
                .fetch();
    }

    @Override
    public OrdersRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.ORDERS)
                .where(Tables.ORDERS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public OrdersRecord save(Orders entity) {
        OrdersRecord record = this.dslContext.newRecord(Tables.ORDERS, entity);
        record.store();
        return record;
    }

    @Override
    public OrdersRecord update(Orders entity) {
        OrdersRecord record = this.dslContext.newRecord(Tables.ORDERS, entity);
        record.update();
        return record;
    }

    @Override
    public void delete(Long id) {
        this.dslContext.delete(Tables.ORDERS)
                .where(Tables.ORDERS.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.ORDERS)
                .where(Tables.ORDERS.ID.eq(Math.toIntExact(id)))
                .fetchOne(0, Integer.class) > 0;
    }
}
