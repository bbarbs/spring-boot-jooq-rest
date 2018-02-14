package com.jooq.feature.service.impl;

import com.jooq.core.exception.global.PatchOperationNotSupported;
import com.jooq.core.rest.patch.Patch;
import com.jooq.core.rest.patch.PatchEnum;
import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.exception.PassportNotFoundException;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.repository.AddressRepository;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.repository.PassportRepository;
import com.jooq.feature.service.AddressService;
import com.jooq.feature.service.CustomerService;
import com.jooq.feature.service.PassportService;
import com.jooq.my_schema.tables.pojos.Address;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.pojos.Passport;
import com.jooq.my_schema.tables.records.AddressRecord;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.PassportRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService, AddressService, PassportService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PassportRepository passportRepository;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        // Get list of customers.
        List<CustomerRecord> customerRecords = this.customerRepository.findAll();
        customerRecords.stream()
                .forEach(customerRecord -> customers.add(customerRecord.into(Customer.class)));
        return customers;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return this.customerRepository.save(customer).into(Customer.class);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        return record.into(Customer.class);
    }

    @Override
    public Customer patchCustomer(Long customerId, Patch patch) {
        if (!patch.getPatchEnum().equals(PatchEnum.REPLACE)) {
            throw new PatchOperationNotSupported("Patch operation not supported");
        }
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Map record to pojo.
        Customer customer = customerRecord.into(Customer.class);
        if (patch.getField().equalsIgnoreCase("firstname")) {
            customer.setFirstname(patch.getValue());
        } else if (patch.getField().equalsIgnoreCase("lastname")) {
            customer.setLastname(patch.getValue());
        }
        return this.customerRepository.update(customer).into(Customer.class);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Add id.
        customer.setId(record.getId());
        return this.customerRepository.update(customer).into(Customer.class);
    }

    @Override
    public void removeCustomerById(Long customerId) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        this.customerRepository.delete(customerId);
    }

    @Override
    public Address addCustomerAddress(Long customerId, Address address) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Add customer id.
        address.setFkCustId(record.getId());
        return this.addressRepository.save(address).into(Address.class);
    }

    @Override
    public List<Address> getAddressByCustomerId(Long customerId) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<Address> list = new ArrayList<>();
        List<AddressRecord> records = this.addressRepository.getAddressByCustomerId(customerId);
        records.stream()
                .forEach(addressRecord -> list.add(addressRecord.into(Address.class)));
        return list;
    }

    @Override
    public List<Address> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<Address> list = new ArrayList<>();
        List<AddressRecord> records = this.addressRepository.getAddressByCustIdAndAddressType(customerId, type);
        records.stream()
                .forEach(addressRecord -> list.add(addressRecord.into(Address.class)));
        return list;
    }

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
