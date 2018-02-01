package com.jooq.feature.model;

import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.my_schema.tables.records.AddressRecord;
import io.swagger.annotations.ApiModelProperty;
import org.jooq.RecordMapper;

public class AddressDto implements RecordMapper<AddressRecord, AddressDto> {

    @ApiModelProperty(hidden = true)
    private Long addressId;

    @ApiModelProperty(required = true)
    private String address;

    @ApiModelProperty(required = true)
    private AddressEnum addressType;

    public AddressDto() {
    }

    public AddressDto(Long addressId, String address, AddressEnum addressType) {
        this.addressId = addressId;
        this.address = address;
        this.addressType = addressType;
    }

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

    @Override
    public AddressDto map(AddressRecord record) {
        return new AddressDto(Long.valueOf(record.getId()), record.getAddress(), AddressEnum.valueOf(record.getType()));
    }
}
