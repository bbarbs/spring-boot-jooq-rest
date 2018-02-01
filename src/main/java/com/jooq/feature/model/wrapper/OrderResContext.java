package com.jooq.feature.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jooq.feature.model.ItemDto;
import com.jooq.feature.model.OrderDto;

import java.util.List;

/**
 * Wrapper for order response.
 */

public class OrderResContext {

    private OrderDto order;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ItemDto> items;

    public OrderResContext() {
    }

    public OrderResContext(OrderDto order, List<ItemDto> items) {
        this.order = order;
        this.items = items;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
