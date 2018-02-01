package com.jooq.feature.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.PassportDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Customer context wrapper.
 */

public class CustomerContext {

    private CustomerDto customer;

    @ApiModelProperty(hidden = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PassportDto passport;

    @ApiModelProperty(hidden = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddressDto> address;

    public CustomerContext() {
    }

    public CustomerContext(CustomerDto customer, PassportDto passport, List<AddressDto> address) {
        this.customer = customer;
        this.passport = passport;
        this.address = address;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public PassportDto getPassport() {
        return passport;
    }

    public void setPassport(PassportDto passport) {
        this.passport = passport;
    }

    public List<AddressDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }
}
