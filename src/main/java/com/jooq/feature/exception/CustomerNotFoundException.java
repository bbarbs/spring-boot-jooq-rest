package com.jooq.feature.exception;

import com.jooq.core.exception.ApiException;

public class CustomerNotFoundException extends ApiException {

    public CustomerNotFoundException(String s) {
        super(s);
    }

    public CustomerNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
