package com.jooq.core.exception.handler;

import com.jooq.core.exception.ApiException;
import com.jooq.core.exception.ApiExceptionMessage;
import com.jooq.core.exception.ErrorMessage;
import com.jooq.core.exception.global.PatchOperationNotSupported;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Patch operation not supported exception.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(PatchOperationNotSupported.class)
    public ResponseEntity<ApiExceptionMessage> patchOperationNotSupported(ApiException e) {
        return new ResponseEntity<>(new ApiExceptionMessage(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                new ErrorMessage(e.getMessage())
        ), HttpStatus.NOT_FOUND);
    }
}
