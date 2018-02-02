package com.jooq.feature.repository;


import com.jooq.core.repository.IGenericRepository;
import com.jooq.my_schema.tables.records.CustomerRecord;

public interface CustomerRepository extends IGenericRepository<CustomerRecord> {

    boolean existByName(CustomerRecord entity);
}
