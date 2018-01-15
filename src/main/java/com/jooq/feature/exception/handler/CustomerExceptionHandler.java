package com.jooq.feature.exception.handler;

import com.jooq.core.exception.ErrorMessage;
import com.jooq.core.exception.ApiException;
import com.jooq.core.exception.ApiExceptionMessage;
import com.jooq.feature.exception.AddressNotFoundException;
import com.jooq.feature.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

/**
 * Rest exceptin handler.
 */

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ApiExceptionMessage customerNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ApiExceptionMessage addressNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }
}
