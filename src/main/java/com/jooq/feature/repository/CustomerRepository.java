package com.jooq.feature.repository;


import com.jooq.core.dao.IGenericDao;
import com.jooq.my_schema.tables.records.CustomerRecord;

public interface CustomerRepository extends IGenericDao<CustomerRecord> {

    boolean existByName(CustomerRecord entity);
}
