package com.jooq.service;

import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.PassportDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.model.wrapper.CustomerWrapper;
import com.jooq.feature.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Inject
    CustomerServiceImpl customerService;

    @Test
    public void testShouldAddCustomer() {
        // Customer
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1);
        customerDto.setFirstname("Test");
        customerDto.setLastname("Test");
        // Passport
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1);
        passportDto.setPassportNumber("12222");
        // Address
        AddressDto addressDto = new AddressDto();
        addressDto.setId(1);
        addressDto.setType(AddressEnum.PRIMARY);
        addressDto.setAddress("Cebu");
        // Set context.
        CustomerWrapper context = new CustomerWrapper();
        context.setCustomer(customerDto);
        context.setPassport(passportDto);
        context.setAddress(Arrays.asList(addressDto));
        // Result
        CustomerWrapper result = this.customerService.addCustomer(context);
        assertNotNull(result);
        assertThat(result.getCustomer().getFirstname()).isEqualTo(customerDto.getFirstname());
    }
}
