package com.jooq.feature.model.wrapper;

import com.jooq.feature.model.OrderDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Wrapper for order request.
 */

public class OrderRequestWrapper {

    private OrderDto order;

    @ApiModelProperty(required = true)
    private List<Long> itemIds;

    public OrderRequestWrapper() {
    }

    public OrderRequestWrapper(OrderDto order, List<Long> itemIds) {
        this.order = order;
        this.itemIds = itemIds;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
