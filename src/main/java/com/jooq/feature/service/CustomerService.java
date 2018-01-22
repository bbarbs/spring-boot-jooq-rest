package com.jooq.feature.service;

import com.jooq.core.rest.patch.Patch;
import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.PassportDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.model.wrapper.CustomerContext;
import com.jooq.my_schema.tables.pojos.Address;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.pojos.Passport;
import com.jooq.my_schema.tables.records.AddressRecord;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.PassportRecord;

import java.util.List;

public interface CustomerService {

    List<CustomerContext> getAllCustomersInfo();

    CustomerContext addCustomer(CustomerContext context);

    CustomerContext getCustomerById(Long id);

    List<AddressDto> getAddressByCustomerId(Long id);

    List<AddressDto> getAddressByCustIdAndAddressType(Long id, AddressEnum type);

    PassportDto getPassportByCustomerId(Long id);

    CustomerDto patchCustomerInfo(Long id, Patch patch);

    PassportDto updateCustomerPassport(Long id, PassportDto dto);

    void removeCustomerById(Long id);
}
