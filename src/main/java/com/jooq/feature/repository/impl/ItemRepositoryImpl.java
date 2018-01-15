package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.ItemRepository;
import com.jooq.my_schema.tables.Items;
import com.jooq.my_schema.tables.records.ItemsRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<ItemsRecord> findAll() {
        return this.dslContext.selectFrom(Items.ITEMS)
                .fetch();
    }

    @Override
    public ItemsRecord findOne(Long id) {
        return this.dslContext.selectFrom(Items.ITEMS)
                .where(Items.ITEMS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public ItemsRecord save(ItemsRecord entity) {
        return this.dslContext.insertInto(Items.ITEMS)
                .set(Items.ITEMS.CODE, entity.getCode())
                .set(Items.ITEMS.ITEM_NAME, entity.getItemName())
                .set(Items.ITEMS.DESCRIPTION, entity.getDescription())
                .returning()
                .fetchOne();
    }

    @Override
    public ItemsRecord update(Long id, ItemsRecord entity) {
        return this.dslContext.update(Items.ITEMS)
                .set(Items.ITEMS.CODE, entity.getCode())
                .set(Items.ITEMS.ITEM_NAME, entity.getItemName())
                .set(Items.ITEMS.DESCRIPTION, entity.getDescription())
                .where(Items.ITEMS.ID.eq(Math.toIntExact(id)))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(Items.ITEMS)
                .where(Items.ITEMS.ID.eq(Math.toIntExact(id)))
                .execute();
    }
}
