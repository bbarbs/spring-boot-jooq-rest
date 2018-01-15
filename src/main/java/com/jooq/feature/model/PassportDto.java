package com.jooq.feature.model;

import com.jooq.my_schema.tables.records.PassportRecord;
import org.jooq.RecordMapper;

public class PassportDto implements RecordMapper<PassportRecord, PassportDto> {

    private int id;
    private String passportNumber;

    public PassportDto() {
    }

    public PassportDto(int id, String passportNumber) {
        this.id = id;
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public PassportDto map(PassportRecord record) {
        return new PassportDto(record.getId(), record.getPassportNumber());
    }
}
