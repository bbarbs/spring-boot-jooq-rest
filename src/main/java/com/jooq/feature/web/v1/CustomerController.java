package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.core.rest.patch.Patch;
import com.jooq.feature.mapper.CustomerMapper;
import com.jooq.feature.model.dto.CustomerDto;
import com.jooq.feature.service.CustomerService;
import com.jooq.my_schema.tables.pojos.Customer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

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
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerService.getAllCustomers();
        return this.customerMapper.mapToCustomerDtoList(customers);
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
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CustomerDto> addCustomer(@ApiParam(value = "Customer complete details", required = true) @RequestBody CustomerDto dto) {
        Customer customer = this.customerService.addCustomer(this.customerMapper.mapToCustomer(dto));
        return new ApiResponse<>(HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.customerMapper.mapToCustomerDto(customer)));
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
        Customer customer = this.customerService.getCustomerById(customerId);
        return this.customerMapper.mapToCustomerDto(customer);
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
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CustomerDto> patchCustomer(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                  @ApiParam(value = "Patch info", required = true) @RequestBody Patch patch) {
        Customer customer = this.customerService.patchCustomer(customerId, patch);
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.customerMapper.mapToCustomerDto(customer))
        );
    }

    /**
     * Update customer by id.
     *
     * @param customerId
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Update customer by Id"
    )
    @PutMapping(
            value = "/customers/{customerId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CustomerDto> updateCustomerById(@ApiParam(value = "Customer Id", required = true) @PathVariable(name = "customerId") Long customerId,
                                                       @ApiParam(value = "Customer details", required = true) @RequestBody CustomerDto dto) {
        Customer customer = this.customerService.updateCustomer(customerId, this.customerMapper.mapToCustomer(dto));
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.customerMapper.mapToCustomerDto(customer))
        );
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCustomerById(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        this.customerService.removeCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
