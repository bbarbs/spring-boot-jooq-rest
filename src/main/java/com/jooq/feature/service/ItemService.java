package com.jooq.feature.service;

import com.jooq.my_schema.tables.pojos.Items;

import java.util.List;

public interface ItemService {

    /**
     * Get list of items.
     *
     * @return
     */
    List<Items> getAllItems();

    /**
     * Add new item.
     *
     * @param items
     * @return
     */
    Items addItem(Items items);

    /**
     * Get items by order.
     *
     * @param orderId
     * @return
     */
    List<Items> getItemsByOrderId(Long orderId);
}
