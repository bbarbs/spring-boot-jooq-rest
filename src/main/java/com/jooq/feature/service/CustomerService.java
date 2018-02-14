package com.jooq.feature.service;

import com.jooq.core.rest.patch.Patch;
import com.jooq.my_schema.tables.pojos.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * Get list of customers.
     *
     * @return
     */
    List<Customer> getAllCustomers();

    /**
     * Add customer order.
     *
     * @param customer
     * @return
     */
    Customer addCustomer(Customer customer);

    /**
     * Get customer by id.
     *
     * @param customerId
     * @return
     */
    Customer getCustomerById(Long customerId);

    /**
     * Patch customer data.
     *
     * @param customerId
     * @param patch
     * @return
     */
    Customer patchCustomer(Long customerId, Patch patch);

    /**
     * Update customer.
     *
     * @param customerId
     * @param customer
     * @return
     */
    Customer updateCustomer(Long customerId, Customer customer);

    /**
     * Remove customer.
     *
     * @param customerId
     */
    void removeCustomerById(Long customerId);
}
