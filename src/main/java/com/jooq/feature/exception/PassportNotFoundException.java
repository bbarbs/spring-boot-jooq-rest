package com.jooq.feature.exception;

import com.jooq.core.exception.ApiException;

public class PassportNotFoundException extends ApiException {

    public PassportNotFoundException(String s) {
        super(s);
    }

    public PassportNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
