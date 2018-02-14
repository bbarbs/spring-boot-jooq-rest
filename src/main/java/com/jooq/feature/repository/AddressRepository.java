package com.jooq.feature.repository;

import com.jooq.core.repository.JooqRepository;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.my_schema.tables.pojos.Address;
import com.jooq.my_schema.tables.records.AddressRecord;

import java.util.List;

public interface AddressRepository extends JooqRepository<AddressRecord, Address, Long> {

    /**
     * Get list of addresses by customer.
     *
     * @param customerId
     * @return
     */
    List<AddressRecord> getAddressByCustomerId(Long customerId);

    /**
     * Get list of customer address by type.
     *
     * @param customerId
     * @param type
     * @return
     */
    List<AddressRecord> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type);
}
