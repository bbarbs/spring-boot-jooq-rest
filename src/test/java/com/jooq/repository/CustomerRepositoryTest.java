package com.jooq.repository;

import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.repository.impl.CustomerRepositoryImpl;
import com.jooq.my_schema.Keys;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.Customer;
import com.jooq.my_schema.tables.records.AddressRecord;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.jooq.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    DSLContext dslContext;

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

    /*@Test
    public void testShouldGetCustommerFromAddressFK() {
        CustomerDto cust = new CustomerDto();
        cust.setId(1);
        cust.setFirstname("test");
        cust.setLastname("test");

        AddressDto address = new AddressDto();
        address.setId(1);
        address.setAddress("newAddress");

        CustomerRecord custRecord = this.dslContext.insertInto(Tables.CUSTOMER)
                .set(Tables.CUSTOMER.ID, cust.getId())
                .set(Tables.CUSTOMER.FIRSTNAME, cust.getFirstname())
                .set(Tables.CUSTOMER.LASTNAME, cust.getLastname())
                .returning(Tables.CUSTOMER.ID)
                .fetchOne();

        AddressRecord addRecord = this.dslContext.insertInto(Tables.ADDRESS)
                .set(Tables.ADDRESS.ID, address.getId())
                .set(Tables.ADDRESS.ADDRESS_, address.getAddress())
                .set(Tables.ADDRESS.FK_CUST_ID, custRecord.getId())
                .returning()
                .fetchOne();

        AddressRecord addResult = this.dslContext.selectFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.ID.eq(1))
                .fetchOne();

        //CustomerRecord custResult = ForeignKey
        //logger.info("FetchChildren: " + addResult.getTable().get);

    }*/
}
