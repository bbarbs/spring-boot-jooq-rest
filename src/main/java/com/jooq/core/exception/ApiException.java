package com.jooq.core.exception;

public class ApiException extends RuntimeException {

    public ApiException(String s) {
        super(s);
    }

    public ApiException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
