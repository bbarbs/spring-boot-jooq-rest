package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.core.rest.patch.Patch;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.wrapper.CustomerWrapper;
import com.jooq.feature.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController {

    @Inject
    CustomerService customerService;

    /**
     * Get list of customers.
     *
     * @return
     */
    @ApiOperation(
            value = "Get all customer list"
    )
    @GetMapping(
            value = "/customers",
            produces = APPLICATION_JSON_VALUE
    )
    public List<CustomerWrapper> getAllCustomers() {
        return this.customerService.getAllCustomersInfo();
    }

    /**
     * Add customer.
     *
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Add new customer"
    )
    @PostMapping(
            value = "/customers",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ApiResponse<CustomerDto> addCustomer(@ApiParam(value = "Customer complete details", required = true) @RequestBody CustomerDto dto) {
        CustomerDto customerDto = this.customerService.addCustomer(dto);
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(customerDto));
    }

    /**
     * Get customer by id.
     *
     * @param customerId
     * @return
     */
    @ApiOperation(
            value = "Get customer details by Id"
    )
    @GetMapping(
            value = "/customers/{customerId}",
            produces = APPLICATION_JSON_VALUE
    )
    public CustomerDto getCustomerById(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        return this.customerService.getCustomerById(customerId);
    }

    /**
     * Patch customer info.
     *
     * @param customerId
     * @param patch
     * @return
     */
    @ApiOperation(
            value = "Patch customer info"
    )
    @PatchMapping(
            value = "/customers/{customerId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ApiResponse<CustomerDto> patchCustomerInfo(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                      @ApiParam(value = "Patch info", required = true) @RequestBody Patch patch) {
        CustomerDto dto = this.customerService.patchCustomerInfo(customerId, patch);
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(dto));
    }

    /**
     * Delete customer.
     *
     * @param customerId
     * @return
     */
    @ApiOperation(
            value = "Delete customer by Id"
    )
    @DeleteMapping(
            value = "/customers/{customerId}",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> deleteCustomerById(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        this.customerService.removeCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
