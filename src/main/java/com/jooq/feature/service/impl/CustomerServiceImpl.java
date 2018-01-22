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
import org.jooq.Result;
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
        for(CustomerRecord customerRecord : customerRecords) {
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
    public CustomerContext addCustomer(CustomerContext context) {
        CustomerContext customerContext = new CustomerContext();
        // Set customer details.
        CustomerRecord custRecord = new CustomerRecord();
        custRecord.setFirstname(context.getCustomer().getFirstname());
        custRecord.setLastname(context.getCustomer().getLastname());
        // Add to db.
        CustomerRecord persistCustRecord = this.customerRepository.save(custRecord);
        // Set address.
        List<AddressRecord> addressRecordList = new ArrayList<>();
        for(AddressDto addressDto : context.getAddress()) {
            AddressRecord addressRecord = new AddressRecord();
            addressRecord.setAddress(addressDto.getAddress());
            addressRecord.setType(String.valueOf(addressDto.getType()));
            addressRecord.setFkCustId(persistCustRecord.getId());
            AddressRecord persistAddrRecord = this.addressRepository.save(addressRecord);
            // Add to list and persist to db.
            addressRecordList.add(persistAddrRecord);
        }
        // Set passport.
        PassportRecord passRecord = new PassportRecord();
        passRecord.setPassportNumber(context.getPassport().getPassportNumber());
        passRecord.setFkCustId(persistCustRecord.getId());
        // Persist.
        PassportRecord persistPassRecord = this.passportRepository.save(passRecord);
        // Set customer context.
        customerContext.setCustomer(new CustomerDto().map(persistCustRecord));
        customerContext.setPassport(new PassportDto().map(persistPassRecord));
        List<AddressDto> addressDtos = new ArrayList<>();
        for(AddressRecord record : addressRecordList) {
            AddressDto dto = new AddressDto();
            dto.setId(record.getId());
            dto.setAddress(record.getAddress());
            dto.setType(AddressEnum.valueOf(record.getType()));
            addressDtos.add(dto);
        }
        customerContext.setAddress(addressDtos);
        return customerContext;
    }

    @Override
    public CustomerContext getCustomerById(Long id) throws CustomerNotFoundException {
        CustomerContext context = new CustomerContext();
        // Get customer.
        CustomerRecord customerRecord = this.customerRepository.findOne(id);
        if(customerRecord == null) {
            throw new CustomerNotFoundException("Customer id not found");
        }
        context.setCustomer(new CustomerDto().map(customerRecord));
        // Get passport.
        List<PassportRecord> passportRecords = Keys.CONSTRAINT_77.fetchChildren(customerRecord);
        context.setPassport(new PassportDto().map(passportRecords.get(0)));
        // Get address.
        List<AddressRecord> addressRecords = Keys.CONSTRAINT_E6.fetchChildren(customerRecord);
        List<AddressDto> addressDtos = new ArrayList<>();
        addressRecords.stream().forEach(addressRecord -> addressDtos.addAll(Arrays.asList(new AddressDto().map(addressRecord))));
        context.setAddress(addressDtos);
        return context;
    }

    @Override
    public List<AddressDto> getAddressByCustomerId(Long id) throws AddressNotFoundException {
        List<AddressRecord> records = this.addressRepository.getAddressByCustomerId(id);
        if(records.size() == 0 || records.isEmpty()) {
            throw new AddressNotFoundException("Customer address not found");
        }
        List<AddressDto> dtos = new ArrayList<>();
        records.stream().forEach(addressRecord -> dtos.add(new AddressDto().map(addressRecord)));
        return dtos;
    }

    @Override
    public List<AddressDto> getAddressByCustIdAndAddressType(Long id, AddressEnum type) throws AddressNotFoundException {
        List<AddressRecord> records = this.addressRepository.getAddressByCustIdAndAddressType(id, type);
        if(records.size() == 0 || records.isEmpty()) {
            throw new AddressNotFoundException("Customer address not found");
        }
        List<AddressDto> dtos = new ArrayList<>();
        records.stream().forEach(addressRecord -> dtos.add(new AddressDto().map(addressRecord)));
        return dtos;
    }

    @Override
    public PassportDto getPassportByCustomerId(Long id) throws PassportNotFoundException {
        PassportDto dto = this.passportRepository.getPassportByCustomerId(id).map(record -> new PassportDto().map((PassportRecord) record));
        if(dto == null) {
            throw new PassportNotFoundException("Passport not found");
        }
        return dto;
    }

    @Override
    public CustomerDto patchCustomerInfo(Long id, Patch patch) throws PatchOperationNotSupported,
            CustomerNotFoundException {
        if(!patch.getPatchEnum().equals(PatchEnum.REPLACE)) {
            throw new PatchOperationNotSupported("Patch operation not supported");
        }
        CustomerRecord customerRecord = this.customerRepository.findOne(id);
        if(customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        if(patch.getField().equals(Customer.CUSTOMER.FIRSTNAME)) {
            customerRecord.setFirstname(patch.getValue());
        }
        else if(patch.getField().equals(Customer.CUSTOMER.LASTNAME)) {
            customerRecord.setLastname(patch.getValue());
        }
        return this.customerRepository.update(id, customerRecord).map(record -> new CustomerDto().map((CustomerRecord) record));
    }

    @Override
    public PassportDto updateCustomerPassport(Long id, PassportDto dto) throws CustomerNotFoundException,
            PassportNotFoundException {
        CustomerRecord customerRecord = this.customerRepository.findOne(id);
        if(customerRecord == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        PassportRecord passportRecord = this.passportRepository.getPassportByCustomerId(id);
        if(passportRecord == null) {
            throw new PassportNotFoundException("Passport not found");
        }
        passportRecord.setPassportNumber(dto.getPassportNumber());
        return this.passportRepository.update(id, passportRecord).map(record -> new PassportDto().map((PassportRecord) record));
    }

    @Override
    public void removeCustomerById(Long id) throws CustomerNotFoundException {
        CustomerRecord record = this.customerRepository.findOne(id);
        if(record == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        this.customerRepository.deleteById(id);
    }
}
