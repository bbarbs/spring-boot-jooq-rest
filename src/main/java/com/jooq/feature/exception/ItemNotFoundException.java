package com.jooq.feature.exception;

import com.jooq.core.exception.ApiException;

public class ItemNotFoundException extends ApiException {

    public ItemNotFoundException(String s) {
        super(s);
    }

    public ItemNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
