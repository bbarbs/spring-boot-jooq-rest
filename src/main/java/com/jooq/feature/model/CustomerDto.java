package com.jooq.feature.model;

import com.jooq.my_schema.tables.records.CustomerRecord;
import io.swagger.annotations.ApiModelProperty;
import org.jooq.RecordMapper;

public class CustomerDto implements RecordMapper<CustomerRecord, CustomerDto> {

    @ApiModelProperty(hidden = true)
    private Long customerId;

    @ApiModelProperty(required = true)
    private String firstname;

    @ApiModelProperty(required = true)
    private String lastname;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String firstname, String lastname) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public CustomerDto map(CustomerRecord record) {
        return new CustomerDto(Long.valueOf(record.getId()), record.getFirstname(), record.getLastname());
    }
}
