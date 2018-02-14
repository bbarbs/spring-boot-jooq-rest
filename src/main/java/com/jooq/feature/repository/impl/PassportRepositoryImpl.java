package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.PassportRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.Passport;
import com.jooq.my_schema.tables.records.PassportRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassportRepositoryImpl implements PassportRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public PassportRecord getPassportByCustomerId(Long customerId) {
        return this.dslContext.selectFrom(Tables.PASSPORT)
                .where(Tables.PASSPORT.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .fetchOne();
    }

    @Override
    public List<PassportRecord> findAll() {
        return this.dslContext.selectFrom(Tables.PASSPORT)
                .fetch();
    }

    @Override
    public PassportRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.PASSPORT)
                .where(Tables.PASSPORT.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public PassportRecord save(Passport entity) {
        PassportRecord record = this.dslContext.newRecord(Tables.PASSPORT, entity);
        record.store();
        return record;
    }

    @Override
    public PassportRecord update(Passport entity) {
        PassportRecord record = this.dslContext.newRecord(Tables.PASSPORT, entity);
        record.update();
        return record;
    }

    @Override
    public void delete(Long id) {
        this.dslContext.delete(Tables.PASSPORT)
                .where(Tables.PASSPORT.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.PASSPORT)
                .where(Tables.PASSPORT.ID.eq(Math.toIntExact(id)))
                .fetchOne(0, Integer.class) > 0;
    }
}
