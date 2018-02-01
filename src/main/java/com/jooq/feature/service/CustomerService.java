package com.jooq.feature.service;

import com.jooq.core.rest.patch.Patch;
import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.PassportDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.model.wrapper.CustomerContext;

import java.util.List;

public interface CustomerService {

    List<CustomerContext> getAllCustomersInfo();

    CustomerDto addCustomer(CustomerDto dto);

    CustomerDto getCustomerById(Long customerId);

    CustomerDto patchCustomerInfo(Long customerId, Patch patch);

    AddressDto addCustomerAddress(Long customerId, AddressDto dto);

    List<AddressDto> getAddressByCustomerId(Long customerId);

    List<AddressDto> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type);

    PassportDto getPassportByCustomerId(Long customerId);

    PassportDto addCustomerPassport(Long customerId, PassportDto dto);

    PassportDto updateCustomerPassport(Long passportId, PassportDto dto);

    void removeCustomerById(Long customerId);
}
