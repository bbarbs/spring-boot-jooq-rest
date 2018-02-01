package com.jooq.feature.model;

import com.jooq.my_schema.tables.records.PassportRecord;
import io.swagger.annotations.ApiModelProperty;
import org.jooq.RecordMapper;

public class PassportDto implements RecordMapper<PassportRecord, PassportDto> {

    @ApiModelProperty(hidden = true)
    private Long passportId;

    @ApiModelProperty(required = true)
    private String passportNumber;

    public PassportDto() {
    }

    public PassportDto(Long passportId, String passportNumber) {
        this.passportId = passportId;
        this.passportNumber = passportNumber;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public PassportDto map(PassportRecord record) {
        return new PassportDto(Long.valueOf(record.getId()), record.getPassportNumber());
    }
}
