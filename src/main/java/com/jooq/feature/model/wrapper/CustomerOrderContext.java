package com.jooq.feature.model.wrapper;

import com.jooq.feature.model.CustomerDto;

public class CustomerOrderContext {

    private CustomerDto customer;
    private OrderResContext order;

    public CustomerOrderContext() {
    }

    public CustomerOrderContext(CustomerDto customer, OrderResContext order) {
        this.customer = customer;
        this.order = order;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public OrderResContext getOrder() {
        return order;
    }

    public void setOrder(OrderResContext order) {
        this.order = order;
    }
}
