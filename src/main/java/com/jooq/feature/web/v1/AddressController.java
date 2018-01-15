package com.jooq.feature.web.v1;

import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class AddressController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    CustomerService customerService;

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
        return this.customerService.getAddressByCustomerId(customerId);
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
        return this.customerService.getAddressByCustIdAndAddressType(customerId, type);
    }
}
