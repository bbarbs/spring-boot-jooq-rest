package com.jooq.feature.web.v1;

import com.jooq.core.rest.ApiResponse;
import com.jooq.feature.mapper.AddressMapper;
import com.jooq.feature.model.dto.AddressDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.service.AddressService;
import com.jooq.my_schema.tables.pojos.Address;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class AddressController {

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressService addressService;

    /**
     * Add customer address.
     *
     * @param customerId
     * @param dto
     * @return
     */
    @ApiOperation(
            value = "Add customer address"
    )
    @PostMapping(
            value = "/customers/{customerId}/addresses",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<AddressDto> addCustomerAddress(@ApiParam(value = "Customer Id", required = true) @PathVariable(name = "customerId") Long customerId,
                                                      @ApiParam(value = "Address details", required = true) @RequestBody AddressDto dto) {
        Address address = this.addressService.addCustomerAddress(customerId, this.addressMapper.mapToAddress(dto));
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED,
                Arrays.asList(this.addressMapper.mapToAddressDto(address))
        );
    }

    /**
     * Get address by certain customer.
     *
     * @param customerId
     * @return
     */
    @ApiOperation(
            value = "Get address by customer Id"
    )
    @GetMapping(
            value = "/customers/{customerId}/addresses",
            produces = APPLICATION_JSON_VALUE
    )
    public List<AddressDto> getAddressByCustomerId(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId) {
        List<Address> addresses = this.addressService.getAddressByCustomerId(customerId);
        return this.addressMapper.mapToAddressDtoList(addresses);
    }

    /**
     * Get customer address by address type and using customer id.
     *
     * @param customerId
     * @param type
     * @return
     */
    @ApiOperation(
            value = "Get address by customer id and address type"
    )
    @GetMapping(
            value = "/customers/{customerId}/addresses",
            params = "type",
            produces = APPLICATION_JSON_VALUE
    )
    public List<AddressDto> getAddressByCustIdAndAddressType(@ApiParam(value = "Customer Id", required = true) @PathVariable("customerId") Long customerId,
                                                             @ApiParam(value = "Address type", required = true) @RequestParam("type") AddressEnum type) {
        List<Address> addresses = this.addressService.getAddressByCustIdAndAddressType(customerId, type);
        return this.addressMapper.mapToAddressDtoList(addresses);
    }
}
