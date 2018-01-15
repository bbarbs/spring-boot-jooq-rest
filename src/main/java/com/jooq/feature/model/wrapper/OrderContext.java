package com.jooq.feature.model.wrapper;

import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;

/**
 * Order context wrapper.
 */

public class OrderContext {

    private OrderDto order;
    private ItemDto item;

    public OrderContext() {
    }

    public OrderContext(OrderDto order, ItemDto item) {
        this.order = order;
        this.item = item;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }
}
