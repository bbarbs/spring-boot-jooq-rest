package com.jooq.feature.exception;

import com.jooq.core.exception.ApiException;

public class OrderNotFoundException extends ApiException {

    public OrderNotFoundException(String s) {
        super(s);
    }

    public OrderNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
