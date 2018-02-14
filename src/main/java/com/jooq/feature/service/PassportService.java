package com.jooq.feature.service;

import com.jooq.my_schema.tables.pojos.Passport;

public interface PassportService {

    /**
     * Get passport by customer id.
     *
     * @param customerId
     * @return
     */
    Passport getPassportByCustomerId(Long customerId);

    /**
     * Add customer passport.
     *
     * @param customerId
     * @param passport
     * @return
     */
    Passport addCustomerPassport(Long customerId, Passport passport);

    /**
     * Update customer passport.
     *
     * @param passportId
     * @param passport
     * @return
     */
    Passport updateCustomerPassport(Long passportId, Passport passport);
}
