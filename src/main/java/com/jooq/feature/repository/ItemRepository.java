package com.jooq.feature.repository;

import com.jooq.core.repository.JooqRepository;
import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.records.ItemsRecord;

import java.util.List;

public interface ItemRepository extends JooqRepository<ItemsRecord, Items, Long> {
    List<ItemsRecord> getItemsByOrderId(Long orderId);
}
