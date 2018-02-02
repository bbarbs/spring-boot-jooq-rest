package com.jooq.feature.repository;

import com.jooq.core.repository.IGenericRepository;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;
import com.jooq.my_schema.tables.records.ItemsRecord;

import java.util.List;

public interface ItemOrderRepository extends IGenericRepository<ItemsOrdersRecord> {
    List<ItemsOrdersRecord> getItemOrderByOrderId(Long orderId);
    List<ItemsRecord> getItemsByOrderId(Long orderId);
}
