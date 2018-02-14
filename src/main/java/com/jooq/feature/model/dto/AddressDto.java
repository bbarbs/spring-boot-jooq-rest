package com.jooq.feature.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jooq.feature.model.enums.AddressEnum;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    @ApiModelProperty(hidden = true)
    private Long addressId;

    @ApiModelProperty(required = true)
    private String address;

    @ApiModelProperty(required = true)
    private AddressEnum addressType;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressEnum getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressEnum addressType) {
        this.addressType = addressType;
    }
}
