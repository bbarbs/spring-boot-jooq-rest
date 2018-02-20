package com.jooq.feature.service.impl;

import com.jooq.core.exception.global.PatchOperationNotSupported;
import com.jooq.core.rest.patch.Patch;
import com.jooq.core.rest.patch.PatchEnum;
import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.service.CustomerService;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

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
}
