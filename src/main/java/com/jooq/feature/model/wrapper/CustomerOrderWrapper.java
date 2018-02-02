package com.jooq.feature.model.wrapper;

import com.jooq.feature.model.CustomerDto;

public class CustomerOrderWrapper {

    private CustomerDto customer;
    private OrderResponseWrapper order;

    public CustomerOrderWrapper() {
    }

    public CustomerOrderWrapper(CustomerDto customer, OrderResponseWrapper order) {
        this.customer = customer;
        this.order = order;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public OrderResponseWrapper getOrder() {
        return order;
    }

    public void setOrder(OrderResponseWrapper order) {
        this.order = order;
    }
}
