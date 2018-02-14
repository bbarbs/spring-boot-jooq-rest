package com.jooq.repository;

import com.jooq.feature.model.dto.CustomerDto;
import com.jooq.feature.repository.impl.CustomerRepositoryImpl;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepositoryImpl customerRepository;

    @Test
    public void testShouldSaveCustomer() {
        Customer customer = new Customer();
        customer.setFirstname("test");
        customer.setLastname("test");
        CustomerRecord record = this.customerRepository.save(customer);
        assertNotNull(record);
        assertThat(record.getFirstname()).isEqualTo(customer.getFirstname());
    }
}
