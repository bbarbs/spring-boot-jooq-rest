package com.jooq.feature.repository.impl;

import com.jooq.feature.model.enums.AddressEnum;
import com.jooq.feature.repository.AddressRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.Address;
import com.jooq.my_schema.tables.records.AddressRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<AddressRecord> findAll() {
        return this.dslContext.selectFrom(Tables.ADDRESS)
                .fetch();
    }

    @Override
    public AddressRecord findOne(Long id) {
        return this.dslContext.selectFrom(Address.ADDRESS)
                .where(Address.ADDRESS.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public AddressRecord save(AddressRecord entity) {
        return this.dslContext.insertInto(Address.ADDRESS)
                .set(Address.ADDRESS.TYPE, String.valueOf(entity.getType()))
                .set(Address.ADDRESS.ADDRESS_, entity.getAddress())
                .set(Address.ADDRESS.FK_CUST_ID, entity.getFkCustId())
                .returning()
                .fetchOne();
    }

    @Override
    public AddressRecord update(Long id, AddressRecord entity) {
        return this.dslContext.update(Address.ADDRESS)
                .set(Address.ADDRESS.ADDRESS_, entity.getAddress())
                .set(Address.ADDRESS.TYPE, String.valueOf(entity.getType()))
                .where(Address.ADDRESS.ID.eq(Math.toIntExact(id)))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(Address.ADDRESS)
                .where(Address.ADDRESS.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public List<AddressRecord> getAddressByCustomerId(Long id) {
        return this.dslContext.selectFrom(Address.ADDRESS)
                .where(Address.ADDRESS.FK_CUST_ID.eq(Math.toIntExact(id)))
                .fetch();
    }

    @Override
    public List<AddressRecord> getAddressByCustIdAndAddressType(Long id, AddressEnum type) {
        return this.dslContext.selectFrom(Address.ADDRESS)
                .where(Address.ADDRESS.FK_CUST_ID.eq(Math.toIntExact(id)))
                .and(Address.ADDRESS.TYPE.eq(type.toString()))
                .fetch();
    }
}
