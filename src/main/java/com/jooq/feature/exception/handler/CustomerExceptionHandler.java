package com.jooq.feature.exception.handler;

import com.jooq.core.exception.ApiException;
import com.jooq.core.exception.ApiExceptionMessage;
import com.jooq.core.exception.ErrorMessage;
import com.jooq.feature.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

/**
 * Rest exceptin handler.
 */

@RestControllerAdvice
public class CustomerExceptionHandler {

    /**
     * Api response for {@link CustomerNotFoundException}
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ApiExceptionMessage customerNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }

    /**
     * Api response for {@link AddressNotFoundException}
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AddressNotFoundException.class)
    public ApiExceptionMessage addressNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }

    /**
     * Api response for {@link PassportNotFoundException}
     *
     * @param e
     * @return
     */
    @ExceptionHandler(PassportNotFoundException.class)
    public ApiExceptionMessage passportNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }

    /**
     * Api response for {@link ItemNotFoundException}
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ItemNotFoundException.class)
    public ApiExceptionMessage itemNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }

    /**
     * Api response for {@link OrderNotFoundException}
     *
     * @param e
     * @return
     */
    @ExceptionHandler(OrderNotFoundException.class)
    public ApiExceptionMessage orderNotFoundException(ApiException e) {
        return new ApiExceptionMessage(new Date(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND, new ErrorMessage(e.getMessage()));
    }
}
