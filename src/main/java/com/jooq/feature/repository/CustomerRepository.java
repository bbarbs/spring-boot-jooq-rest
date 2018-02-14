package com.jooq.feature.repository;


import com.jooq.core.repository.JooqRepository;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;

public interface CustomerRepository extends JooqRepository<CustomerRecord, Customer, Long> {
}
