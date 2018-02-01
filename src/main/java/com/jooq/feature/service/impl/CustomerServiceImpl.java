package com.jooq.feature.service.impl;

import com.jooq.core.exception.global.PatchOperationNotSupported;
import com.jooq.core.rest.patch.Patch;
import com.jooq.core.rest.patch.PatchEnum;
import com.jooq.feature.exception.AddressNotFoundException;
import com.jooq.feature.exception.CustomerNotFoundException;
import com.jooq.feature.exception.PassportNotFoundException;
import com.jooq.feature.model.AddressDto;
import com.jooq.feature.model.CustomerDto;
import com.jooq.feature.model.PassportDto;
import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.model.wrapper.CustomerContext;
import com.jooq.feature.repository.AddressRepository;
import com.jooq.feature.repository.CustomerRepository;
import com.jooq.feature.repository.PassportRepository;
import com.jooq.feature.service.CustomerService;
import com.jooq.my_schema.Keys;
import com.jooq.my_schema.tables.Customer;
import com.jooq.my_schema.tables.records.AddressRecord;
import com.jooq.my_schema.tables.records.CustomerRecord;
import com.jooq.my_schema.tables.records.PassportRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    AddressRepository addressRepository;

    @Inject
    PassportRepository passportRepository;

    @Override
    public List<CustomerContext> getAllCustomersInfo() {
        List<CustomerContext> list = new ArrayList<>();
        // Get list of customers.
        List<CustomerRecord> customerRecords = this.customerRepository.findAll();
        // Get customer additional details.
        for (CustomerRecord customerRecord : customerRecords) {
            CustomerContext context = new CustomerContext();
            context.setCustomer(new CustomerDto().map(customerRecord));
            // Get customer passport.
            List<PassportRecord> passportRecords = Keys.CONSTRAINT_77.fetchChildren(customerRecord);
            passportRecords.stream().forEach(passportRecord -> context.setPassport(new PassportDto().map(passportRecord)));
            // Get address.
            List<AddressRecord> addressRecords = Keys.CONSTRAINT_E6.fetchChildren(customerRecord);
            List<AddressDto> addressDtos = new ArrayList<>();
            addressRecords.stream().forEach(addressRecord -> addressDtos.addAll(Arrays.asList(new AddressDto().map(addressRecord))));
            context.setAddress(addressDtos);
            // Add to list.
            list.add(context);
        }
        return list;
    }

    @Override
    public CustomerDto addCustomer(CustomerDto dto) {
        CustomerRecord custRecord = new CustomerRecord();
        custRecord.setFirstname(dto.getFirstname());
        custRecord.setLastname(dto.getLastname());
        return this.customerRepository.save(custRecord).map(record -> new CustomerDto().map((CustomerRecord) record));
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) throws CustomerNotFoundException {
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer id not found");
        }
        return customerRecord.map(record -> new CustomerDto().map((CustomerRecord) record));
    }

    @Override
    public CustomerDto patchCustomerInfo(Long customerId, Patch patch) throws PatchOperationNotSupported,
            CustomerNotFoundException {
        if (!patch.getPatchEnum().equals(PatchEnum.REPLACE)) {
            throw new PatchOperationNotSupported("Patch operation not supported");
        }
        CustomerRecord customerRecord = this.customerRepository.findOne(customerId);
        if (customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        if (patch.getField().equals(Customer.CUSTOMER.FIRSTNAME)) {
            customerRecord.setFirstname(patch.getValue());
        } else if (patch.getField().equals(Customer.CUSTOMER.LASTNAME)) {
            customerRecord.setLastname(patch.getValue());
        }
        return this.customerRepository.update(customerId, customerRecord).map(record -> new CustomerDto().map((CustomerRecord) record));
    }

    @Override
    public AddressDto addCustomerAddress(Long customerId, AddressDto dto) {
        AddressRecord addressRecord = new AddressRecord();
        addressRecord.setAddress(dto.getAddress());
        addressRecord.setType(String.valueOf(dto.getAddressType()));
        addressRecord.setFkCustId(Math.toIntExact(customerId));
        return this.addressRepository.save(addressRecord).map(record -> new AddressDto().map((AddressRecord) record));
    }

    @Override
    public List<AddressDto> getAddressByCustomerId(Long customerId) throws AddressNotFoundException {
        List<AddressRecord> records = this.addressRepository.getAddressByCustomerId(customerId);
        if (records.size() == 0 || records.isEmpty()) {
            throw new AddressNotFoundException("Customer address not found");
        }
        List<AddressDto> dtos = new ArrayList<>();
        records.stream().forEach(addressRecord -> dtos.add(new AddressDto().map(addressRecord)));
        return dtos;
    }

    @Override
    public List<AddressDto> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type) throws AddressNotFoundException {
        List<AddressRecord> records = this.addressRepository.getAddressByCustIdAndAddressType(customerId, type);
        if (records.size() == 0 || records.isEmpty()) {
            throw new AddressNotFoundException("Customer address not found");
        }
        List<AddressDto> dtos = new ArrayList<>();
        records.stream().forEach(addressRecord -> dtos.add(new AddressDto().map(addressRecord)));
        return dtos;
    }

    @Override
    public PassportDto getPassportByCustomerId(Long customerId) throws PassportNotFoundException {
        PassportDto dto = this.passportRepository.getPassportByCustomerId(customerId).map(record -> new PassportDto().map((PassportRecord) record));
        if (dto == null) {
            throw new PassportNotFoundException("Passport not found");
        }
        return dto;
    }

    @Override
    public PassportDto addCustomerPassport(Long customerId, PassportDto dto) {
        PassportRecord passRecord = new PassportRecord();
        passRecord.setPassportNumber(dto.getPassportNumber());
        passRecord.setFkCustId(Math.toIntExact(customerId));
        return this.passportRepository.save(passRecord).map(record -> new PassportDto().map((PassportRecord) record));
    }

    @Override
    public PassportDto updateCustomerPassport(Long passportId, PassportDto dto) throws CustomerNotFoundException,
            PassportNotFoundException {
        PassportRecord passportRecord = this.passportRepository.findOne(passportId);
        if (passportRecord == null) {
            throw new PassportNotFoundException("Passport not found");
        }
        passportRecord.setPassportNumber(dto.getPassportNumber());
        return this.passportRepository.update(passportId, passportRecord).map(record -> new PassportDto().map((PassportRecord) record));
    }

    @Override
    public void removeCustomerById(Long customerId) throws CustomerNotFoundException {
        CustomerRecord record = this.customerRepository.findOne(customerId);
        if (record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        this.customerRepository.deleteById(customerId);
    }
}
