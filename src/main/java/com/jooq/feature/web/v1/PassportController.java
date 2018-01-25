package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.core.util.RestUtil;
import com.jooq.feature.model.PassportDto;
import com.jooq.feature.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class PassportController {

    @Inject
    CustomerService customerService;

    @Inject
    RestUtil restUtil;

    /**
     * Get passport by certain customer.
     *
     * @param customerId
     * @return
     */
    @ApiOperation(
            value = "Get passport by customer Id"
    )
    @GetMapping(
            value = "/customers/{customerId}/passport",
            produces = APPLICATION_JSON_VALUE
    )
    public PassportDto getPassportByCustomerId(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        return this.customerService.getPassportByCustomerId(customerId);
    }

    /**
     * Update customer passport.
     *
     * @param passportId
     * @param passportDto
     * @return
     */
    @ApiOperation(
            value = "Update customer passport"
    )
    @PutMapping(
            value = "/passports/{passportId}",
            produces = APPLICATION_JSON_VALUE
    )
    public ApiResponse updateCustomerPassport(@ApiParam(value = "Passport Id", required = true) @PathVariable("passportId") Long passportId,
                                              @ApiParam(value = "Passport update", required = true) @RequestBody PassportDto passportDto) {
        PassportDto dto = this.customerService.updateCustomerPassport(passportId, passportDto);
        return this.restUtil.createApiResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED, Arrays.asList(dto));
    }
}
