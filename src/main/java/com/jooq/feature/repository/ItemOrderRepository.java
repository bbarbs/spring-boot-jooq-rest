package com.jooq.feature.repository;

import com.jooq.my_schema.tables.pojos.ItemsOrders;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;

public interface ItemOrderRepository {

    /**
     * Add item order.
     *
     * @param entity
     * @return
     */
    ItemsOrdersRecord save(ItemsOrders entity);
}
