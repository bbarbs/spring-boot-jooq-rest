package com.jooq.feature.model;

import com.jooq.my_schema.tables.daos.CustomerDao;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.jooq.RecordMapper;

public class CustomerDto implements RecordMapper<CustomerRecord, CustomerDto> {

    private int id;
    private String firstname;
    private String lastname;

    public CustomerDto() {
    }

    public CustomerDto(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return new CustomerDto(record.getId(), record.getFirstname(), record.getLastname());
    }
}
