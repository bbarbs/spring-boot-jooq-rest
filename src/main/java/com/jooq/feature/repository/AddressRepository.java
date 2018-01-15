package com.jooq.feature.repository;

import com.jooq.core.dao.IGenericDao;
import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.my_schema.tables.records.AddressRecord;

import java.util.List;

public interface AddressRepository extends IGenericDao<AddressRecord> {

    List<AddressRecord> getAddressByCustomerId(Long customerId);

    List<AddressRecord> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type);
}
