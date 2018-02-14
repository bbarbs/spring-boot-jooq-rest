package com.jooq.feature.repository.impl;

import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.repository.AddressRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.Address;
import com.jooq.my_schema.tables.records.AddressRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<AddressRecord> getAddressByCustomerId(Long customerId) {
        return this.dslContext.selectFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .fetch();
    }

    @Override
    public List<AddressRecord> getAddressByCustIdAndAddressType(Long customerId, AddressEnum type) {
        return this.dslContext.selectFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .and(Tables.ADDRESS.TYPE.eq(type.toString()))
                .fetch();
    }

    @Override
    public List<AddressRecord> findAll() {
        return this.dslContext.selectFrom(Tables.ADDRESS)
                .fetch();
    }

    @Override
    public AddressRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.ADDRESS)
                .where(Tables.ADDRESS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public AddressRecord save(Address entity) {
        AddressRecord record = this.dslContext.newRecord(Tables.ADDRESS, entity);
        record.store();
        return record;
    }

    @Override
    public AddressRecord update(Address entity) {
        AddressRecord record = this.dslContext.newRecord(Tables.ADDRESS, entity);
        record.update();
        return record;
    }

    @Override
    public void delete(Long id) {
        this.dslContext.delete(Tables.ADDRESS)
                .where(Tables.ADDRESS.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.ADDRESS)
                .where(Tables.ADDRESS.ID.eq(Math.toIntExact(id)))
                .fetchOne(0, Integer.class) > 0;
    }
}
