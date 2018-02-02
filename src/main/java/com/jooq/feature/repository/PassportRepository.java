package com.jooq.feature.repository;

import com.jooq.core.repository.IGenericRepository;
import com.jooq.my_schema.tables.records.PassportRecord;

public interface PassportRepository extends IGenericRepository<PassportRecord> {

    PassportRecord getPassportByCustomerId(Long customerId);
}
