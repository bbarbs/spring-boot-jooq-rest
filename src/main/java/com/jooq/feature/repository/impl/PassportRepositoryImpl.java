package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.PassportRepository;
import com.jooq.my_schema.tables.Passport;
import com.jooq.my_schema.tables.records.PassportRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PassportRepositoryImpl implements PassportRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<PassportRecord> findAll() {
        return this.dslContext.selectFrom(Passport.PASSPORT)
                .fetch();
    }

    @Override
    public PassportRecord findOne(Long id) {
        return this.dslContext.selectFrom(Passport.PASSPORT)
                .where(Passport.PASSPORT.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public PassportRecord save(PassportRecord entity) {
        return this.dslContext.insertInto(Passport.PASSPORT)
                .set(Passport.PASSPORT.PASSPORT_NUMBER, entity.getPassportNumber())
                .set(Passport.PASSPORT.FK_CUST_ID, entity.getFkCustId())
                .returning()
                .fetchOne();
    }

    @Override
    public PassportRecord update(Long id, PassportRecord entity) {
        return this.dslContext.update(Passport.PASSPORT)
                .set(Passport.PASSPORT.PASSPORT_NUMBER, entity.getPassportNumber())
                .where(Passport.PASSPORT.ID.eq(Math.toIntExact(id)))
                .and(Passport.PASSPORT.FK_CUST_ID.eq(entity.getFkCustId()))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(Passport.PASSPORT)
                .where(Passport.PASSPORT.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public PassportRecord getPassportByCustomerId(Long customerId) {
        return this.dslContext.selectFrom(Passport.PASSPORT)
                .where(Passport.PASSPORT.FK_CUST_ID.eq(Math.toIntExact(customerId)))
                .fetchOne();
    }
}
