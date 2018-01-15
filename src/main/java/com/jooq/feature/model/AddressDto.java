package com.jooq.feature.model;

import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.my_schema.tables.records.AddressRecord;
import org.jooq.RecordMapper;

public class AddressDto implements RecordMapper<AddressRecord, AddressDto> {

    private int id;
    private String address;
    private AddressEnum type;

    public AddressDto() {
    }

    public AddressDto(int id, String address, AddressEnum type) {
        this.id = id;
        this.address = address;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AddressEnum getType() {
        return type;
    }

    public void setType(AddressEnum type) {
        this.type = type;
    }

    @Override
    public AddressDto map(AddressRecord record) {
        return new AddressDto(record.getId(), record.getAddress(), AddressEnum.valueOf(record.getType()));
    }
}
