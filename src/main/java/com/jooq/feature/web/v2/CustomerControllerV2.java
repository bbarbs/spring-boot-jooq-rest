package com.jooq.feature.web.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * For test only to check different group api in swagger.
 */

@RestController
@RequestMapping(value = "/api/v2")
public class CustomerControllerV2 {

    @GetMapping(
            value = "/customers",
            produces = APPLICATION_JSON_VALUE
    )
    public List<?> getList() {
        return null;
    }
}
