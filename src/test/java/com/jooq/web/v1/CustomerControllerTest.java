package com.jooq.web.v1;

import com.jooq.feature.mapper.CustomerMapper;
import com.jooq.feature.model.dto.CustomerDto;
import com.jooq.feature.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerServiceImpl customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Test
    public void testShouldGetAllCustomers() throws Exception {
        this.mockMvc.perform(get("/api/v1/customers")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testShouldGetCustomerById() throws Exception {
        CustomerDto dto = new CustomerDto();
        dto.setCustomerId(1L);
        dto.setFirstname("Test");
        dto.setLastname("Test");
        when(this.customerService.getCustomerById(anyLong())).thenReturn(this.customerMapper.mapToCustomer(dto));
        this.mockMvc.perform(get("/api/v1/customers/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andDo(print());
    }
}
