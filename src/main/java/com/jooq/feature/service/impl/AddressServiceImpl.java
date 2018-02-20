package com.jooq.feature.service.impl;

import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.repository.AddressRepository;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.service.AddressService;
import com.jooq.my_schema.tables.pojos.Address;
import com.jooq.my_schema.tables.records.AddressRecord;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address addCustomerAddress(Long customerId, Address address) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        // Add customer id.
        address.setFkCustId(record.getId());
        return this.addressRepository.save(address).into(Address.class);
    }

    @Override
    public List<Address> getAddressByCustomerId(Long customerId) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<Address> list = new ArrayList<>();
        List<AddressRecord> records = this.addressRepository.getAddressByCustomerId(customerId);
        records.stream()
                .forEach(addressRecord -> list.add(addressRecord.into(Address.class)));
        return list;
    }

    @Override
    public List<Address> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type) {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        List<Address> list = new ArrayList<>();
        List<AddressRecord> records = this.addressRepository.getAddressByCustIdAndAddressType(customerId, type);
        records.stream()
                .forEach(addressRecord -> list.add(addressRecord.into(Address.class)));
        return list;
    }
}
