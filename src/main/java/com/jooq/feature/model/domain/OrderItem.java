package com.jooq.feature.model.domain;

import com.jooq.my_schema.tables.pojos.Items;
import com.jooq.my_schema.tables.pojos.Orders;

import java.util.List;

public class OrderItem {

    private Orders order;

    private List<Items> items;

    public OrderItem() {
    }

    public OrderItem(Orders order, List<Items> items) {
        this.order = order;
        this.items = items;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
