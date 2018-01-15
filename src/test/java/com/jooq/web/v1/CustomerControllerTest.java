package com.jooq.web.v1;

import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.wrapper.CustomerContext;
import com.jooq.feature.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

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

    @Inject
    MockMvc mockMvc;

    @MockBean
    CustomerServiceImpl customerService;

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
        dto.setId(1);
        dto.setFirstname("Test");
        dto.setLastname("Test");
        CustomerContext context = new CustomerContext();
        context.setCustomer(dto);
        when(this.customerService.getCustomerById(Mockito.anyLong())).thenReturn(context);
        this.mockMvc.perform(get("/api/v1/customers/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andDo(print());
    }
}
