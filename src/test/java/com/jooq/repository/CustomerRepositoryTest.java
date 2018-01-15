package com.jooq.repository;

import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.repository.impl.CustomerRepositoryImpl;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepositoryImpl customerRepository;

    @Test
    public void testShouldSaveCustomer() {
        CustomerDto dto = new CustomerDto();
        dto.setId(1);
        dto.setFirstname("test");
        dto.setLastname("test");
        CustomerRecord record = this.customerRepository.save(new CustomerRecord(dto.getId(), dto.getFirstname(), dto.getLastname()));
        assertNotNull(record);
        assertThat(record.getFirstname()).isEqualTo(dto.getFirstname());
    }
}
