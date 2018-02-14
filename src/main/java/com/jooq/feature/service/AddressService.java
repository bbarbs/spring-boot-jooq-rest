package com.jooq.feature.service;

import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.my_schema.tables.pojos.Address;

import java.util.List;

public interface AddressService {

    /**
     * Add customer address.
     *
     * @param customerId
     * @param address
     * @return
     */
    Address addCustomerAddress(Long customerId, Address address);

    /**
     * Get customer address by id.
     *
     * @param customerId
     * @return
     */
    List<Address> getAddressByCustomerId(Long customerId);

    /**
     * Get address by customer id and address type.
     *
     * @param customerId
     * @param type
     * @return
     */
    List<Address> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type);
}
