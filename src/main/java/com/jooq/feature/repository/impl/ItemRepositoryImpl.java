package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.ItemRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.records.ItemsRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<ItemsRecord> findAll() {
        return this.dslContext.selectFrom(Tables.ITEMS)
                .fetch();
    }

    @Override
    public ItemsRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.ITEMS)
                .where(Tables.ITEMS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public ItemsRecord save(Items entity) {
        ItemsRecord record = this.dslContext.newRecord(Tables.ITEMS, entity);
        record.store();
        return record;
    }

    @Override
    public ItemsRecord update(Items entity) {
        ItemsRecord record = this.dslContext.newRecord(Tables.ITEMS, entity);
        record.update();
        return record;
    }

    @Override
    public void delete(Long id) {
        this.dslContext.delete(Tables.ITEMS)
                .where(Tables.ITEMS.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.ITEMS)
                .where(Tables.ITEMS.ID.eq(Math.toIntExact(id)))
                .fetchOne(0, Integer.class) > 0;
    }

    @Override
    public List<ItemsRecord> getItemsByOrderId(Long orderId) {
        return this.dslContext.select()
                .from(Tables.ITEMS_ORDERS)
                .join(Tables.ITEMS)
                .on(Tables.ITEMS_ORDERS.ITEM_ID.eq(Tables.ITEMS.ID))
                .where(Tables.ITEMS_ORDERS.ORDER_ID.eq(Math.toIntExact(orderId)))
                .fetch()
                .map(record -> new ItemsRecord(
                        record.get(Tables.ITEMS.ID),
                        record.get(Tables.ITEMS.CODE),
                        record.get(Tables.ITEMS.ITEM_NAME),
                        record.get(Tables.ITEMS.DESCRIPTION)
                ));
    }
}
