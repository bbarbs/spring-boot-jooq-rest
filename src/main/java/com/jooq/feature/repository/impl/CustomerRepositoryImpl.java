package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.CustomerRepository;
import com.jooq.my_schema.Tables;
import com.jooq.my_schema.tables.pojos.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public List<CustomerRecord> findAll() {
        return this.dslContext.selectFrom(Tables.CUSTOMER)
                .fetch();
    }

    @Override
    public CustomerRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.CUSTOMER)
                .where(Tables.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public CustomerRecord save(Customer entity) {
        CustomerRecord record = this.dslContext.newRecord(Tables.CUSTOMER, entity);
        record.store();
        return record;
    }

    @Override
    public CustomerRecord update(Customer entity) {
        CustomerRecord record = this.dslContext.newRecord(Tables.CUSTOMER, entity);
        record.update();
        return record;
    }

    @Override
    public void delete(Long id) {
        this.dslContext.deleteFrom(Tables.CUSTOMER)
                .where(Tables.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.CUSTOMER)
                .where(Tables.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .fetchOne(0, Integer.class) > 0;
    }
}
