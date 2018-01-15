package com.jooq.core.exception.global;

import com.jooq.core.exception.ApiException;

public class PatchOperationNotSupported extends ApiException {
    public PatchOperationNotSupported(String s) {
        super(s);
    }

    public PatchOperationNotSupported(String s, Throwable throwable) {
        super(s, throwable);
    }
}
