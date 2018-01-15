package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.ItemOrderRepository;
import com.jooq.my_schema.tables.ItemsOrders;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ItemOrderRepositoryImpl implements ItemOrderRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<ItemsOrdersRecord> findAll() {
        return this.dslContext.selectFrom(ItemsOrders.ITEMS_ORDERS)
                .fetch();
    }

    @Override
    public ItemsOrdersRecord findOne(Long id) {
        return this.dslContext.selectFrom(ItemsOrders.ITEMS_ORDERS)
                .where(ItemsOrders.ITEMS_ORDERS.ORDER_ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public ItemsOrdersRecord save(ItemsOrdersRecord entity) {
        return this.dslContext.insertInto(ItemsOrders.ITEMS_ORDERS)
                .set(ItemsOrders.ITEMS_ORDERS.ORDER_ID, entity.getOrderId())
                .set(ItemsOrders.ITEMS_ORDERS.ITEM_ID, entity.getItemId())
                .returning()
                .fetchOne();
    }

    @Override
    public ItemsOrdersRecord update(Long id, ItemsOrdersRecord entity) {
        return this.dslContext.update(ItemsOrders.ITEMS_ORDERS)
                .set(ItemsOrders.ITEMS_ORDERS.ITEM_ID, entity.getItemId())
                .where(ItemsOrders.ITEMS_ORDERS.ORDER_ID.eq(entity.getOrderId()))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(ItemsOrders.ITEMS_ORDERS)
                .where(ItemsOrders.ITEMS_ORDERS.ORDER_ID.eq(Math.toIntExact(id)));
    }
}
