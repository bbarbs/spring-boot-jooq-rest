package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.mapper.PassportMapper;
import com.jooq.feature.model.dto.PassportDto;
import com.jooq.feature.service.PassportService;
import com.jooq.my_schema.tables.pojos.Passport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class PassportController {

    @Autowired
    PassportService passportService;

    @Autowired
    PassportMapper passportMapper;

    /**
     * Add customer passport.
     *
     * @param customerId
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Add customer passport"
    )
    @PostMapping(
            value = "/customers/{customerId}/passport",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PassportDto> addCustomerPassport(@ApiParam(value = "Customer Id", required = true) @PathVariable(name = "customerId") Long customerId,
                                                        @ApiParam(value = "Passport details", required = true) @RequestBody PassportDto dto) {
        Passport passport = this.passportService.addCustomerPassport(customerId, this.passportMapper.mapToPassport(dto));
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.passportMapper.mapToPassportDto(passport))
        );
    }

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
        Passport passport = this.passportService.getPassportByCustomerId(customerId);
        return this.passportMapper.mapToPassportDto(passport);
    }

    /**
     * Update customer passport.
     *
     * @param passportId
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Update customer passport"
    )
    @PutMapping(
            value = "/passports/{passportId}",
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PassportDto> updateCustomerPassport(@ApiParam(value = "Passport Id", required = true) @PathVariable("passportId") Long passportId,
                                                           @ApiParam(value = "Passport update", required = true) @RequestBody PassportDto dto) {
        Passport passport = this.passportService.updateCustomerPassport(passportId, this.passportMapper.mapToPassport(dto));
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.passportMapper.mapToPassportDto(passport))
        );
    }
}
