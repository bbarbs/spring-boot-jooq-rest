package com.jooq.feature.exception;

import com.jooq.core.exception.ApiException;

public class AddressNotFoundException extends ApiException {
    public AddressNotFoundException(String s) {
        super(s);
    }

    public AddressNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
