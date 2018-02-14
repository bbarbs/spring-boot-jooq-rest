package com.jooq.service;

import com.jooq.feature.service.impl.CustomerServiceImpl;
import com.jooq.my_schema.tables.pojos.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerServiceImpl customerService;

    @Test
    public void testShouldAddCustomer() {
        // Customer
        Customer customer = new Customer();
        customer.setFirstname("Test");
        customer.setLastname("Test");
        Customer result = this.customerService.addCustomer(customer);
        assertNotNull(result);
        assertThat(result.getFirstname()).isEqualTo(customer.getFirstname());
    }
}
