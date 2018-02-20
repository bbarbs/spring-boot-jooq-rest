package com.jooq.feature.service.impl;


import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.exception.PassportNotFoundException;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.repository.PassportRepository;
import com.jooq.feature.service.PassportService;
import com.jooq.my_schema.tables.pojos.Passport;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.PassportRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassportServiceImpl implements PassportService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PassportRepository passportRepository;

    @Override
    public Passport getPassportByCustomerId(Long customerId) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        return this.passportRepository.getPassportByCustomerId(customerId).into(Passport.class);
    }

    @Override
    public Passport addCustomerPassport(Long customerId, Passport passport) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Add customer id.
        passport.setFkCustId(record.getId());
        return this.passportRepository.save(passport).into(Passport.class);
    }

    @Override
    public Passport updateCustomerPassport(Long passportId, Passport passport) {
        PassportRecord record = this.passportRepository.findOne(passportId);
        if (record == null) {
            throw new PassportNotFoundException("Passport not found");
        }
        // Add id.
        passport.setId(record.getId());
        return this.passportRepository.update(passport).into(Passport.class);
    }
}
