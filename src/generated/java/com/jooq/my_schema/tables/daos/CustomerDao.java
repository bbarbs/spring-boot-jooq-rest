/*
 * This file is generated by jOOQ.
*/
package com.jooq.my_schema.tables.daos;


import com.jooq.my_schema.tables.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerDao extends DAOImpl<CustomerRecord, com.jooq.my_schema.tables.pojos.Customer, Integer> {

    /**
     * Create a new CustomerDao without any configuration
     */
    public CustomerDao() {
        super(Customer.CUSTOMER, com.jooq.my_schema.tables.pojos.Customer.class);
    }

    /**
     * Create a new CustomerDao with an attached configuration
     */
    public CustomerDao(Configuration configuration) {
        super(Customer.CUSTOMER, com.jooq.my_schema.tables.pojos.Customer.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.jooq.my_schema.tables.pojos.Customer object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<com.jooq.my_schema.tables.pojos.Customer> fetchById(Integer... values) {
        return fetch(Customer.CUSTOMER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public com.jooq.my_schema.tables.pojos.Customer fetchOneById(Integer value) {
        return fetchOne(Customer.CUSTOMER.ID, value);
    }

    /**
     * Fetch records that have <code>FIRSTNAME IN (values)</code>
     */
    public List<com.jooq.my_schema.tables.pojos.Customer> fetchByFirstname(String... values) {
        return fetch(Customer.CUSTOMER.FIRSTNAME, values);
    }

    /**
     * Fetch records that have <code>LASTNAME IN (values)</code>
     */
    public List<com.jooq.my_schema.tables.pojos.Customer> fetchByLastname(String... values) {
        return fetch(Customer.CUSTOMER.LASTNAME, values);
    }
}
