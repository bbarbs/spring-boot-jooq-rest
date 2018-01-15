package com.jooq.feature.repository.impl;

import com.jooq.feature.model.enums.OrderStatusEnum;
import com.jooq.feature.repository.OrderRepository;
import com.jooq.my_schema.tables.Orders;
import com.jooq.my_schema.tables.records.OrdersRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<OrdersRecord> findAll() {
        return this.dslContext.selectFrom(Orders.ORDERS)
                .fetch();
    }

    @Override
    public OrdersRecord findOne(Long id) {
        return this.dslContext.selectFrom(Orders.ORDERS)
                .where(Orders.ORDERS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public OrdersRecord save(OrdersRecord entity) {
        return this.dslContext.insertInto(Orders.ORDERS)
                .set(Orders.ORDERS.STATUS, entity.getStatus())
                .set(Orders.ORDERS.AMOUNT, entity.getAmount())
                .set(Orders.ORDERS.DATE_ORDER, entity.getDateOrder())
                .set(Orders.ORDERS.FK_CUST_ID, entity.getFkCustId())
                .returning()
                .fetchOne();
    }

    @Override
    public OrdersRecord update(Long id, OrdersRecord entity) {
        return this.dslContext.update(Orders.ORDERS)
                .set(Orders.ORDERS.STATUS, entity.getStatus())
                .set(Orders.ORDERS.AMOUNT, entity.getAmount())
                .set(Orders.ORDERS.DATE_ORDER, entity.getDateOrder())
                .set(Orders.ORDERS.FK_CUST_ID, entity.getFkCustId())
                .where(Orders.ORDERS.ID.eq(Math.toIntExact(id)))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(Orders.ORDERS)
                .where(Orders.ORDERS.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public List<OrdersRecord> getOrdersByCustomerId(Long customerId) {
        return this.dslContext.selectFrom(Orders.ORDERS)
                .where(Orders.ORDERS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .fetch();
    }

    @Override
    public List<OrdersRecord> getCustomerOrderByStatus(Long customerId, OrderStatusEnum status) {
        return this.dslContext.selectFrom(Orders.ORDERS)
                .where(Orders.ORDERS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .and(Orders.ORDERS.STATUS.eq(String.valueOf(status)))
                .fetch();
    }
}
