package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.ItemOrderRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.ItemsOrders;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemOrderRepositoryImpl implements ItemOrderRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public ItemsOrdersRecord save(ItemsOrders entity) {
        ItemsOrdersRecord record = this.dslContext.newRecord(Tables.ITEMS_ORDERS, entity);
        record.insert();
        return record;
    }
}
