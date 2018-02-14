package com.jooq.feature.repository;

import com.jooq.core.repository.JooqRepository;
import com.jooq.my_schema.tables.pojos.Passport;
import com.jooq.my_schema.tables.records.PassportRecord;

public interface PassportRepository extends JooqRepository<PassportRecord, Passport, Long> {

    /**
     * Get passport by customer id.
     *
     * @param customerId
     * @return
     */
    PassportRecord getPassportByCustomerId(Long customerId);
}
