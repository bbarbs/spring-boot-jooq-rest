package com.jooq.feature.repository.impl;

import com.jooq.feature.repository.CustomerRepository;
import com.jooq.my_schema.tables.Customer;
import com.jooq.my_schema.tables.records.CustomerRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Inject
    DSLContext dslContext;

    @Override
    public List<CustomerRecord> findAll() {
        return this.dslContext.selectFrom(Customer.CUSTOMER)
                .fetch();
    }

    @Override
    public CustomerRecord findOne(Long id) {
        return this.dslContext.selectFrom(Customer.CUSTOMER)
                .where(Customer.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .fetchOne();
    }

    @Override
    public CustomerRecord save(CustomerRecord entity) {
        return this.dslContext.insertInto(Customer.CUSTOMER)
                .set(Customer.CUSTOMER.FIRSTNAME, entity.getFirstname())
                .set(Customer.CUSTOMER.LASTNAME, entity.getLastname())
                .returning()
                .fetchOne();
    }

    @Override
    public CustomerRecord update(Long id, CustomerRecord entity) {
        return this.dslContext.update(Customer.CUSTOMER)
                .set(Customer.CUSTOMER.FIRSTNAME, entity.getFirstname())
                .set(Customer.CUSTOMER.LASTNAME, entity.getLastname())
                .where(Customer.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .returning()
                .fetchOne();
    }

    @Override
    public void deleteById(Long id) {
        this.dslContext.delete(Customer.CUSTOMER)
                .where(Customer.CUSTOMER.ID.eq(Math.toIntExact(id)))
                .execute();
    }

    @Override
    public boolean existByName(CustomerRecord entity) {
        return this.dslContext.selectCount()
                .from(Customer.CUSTOMER)
                .where(Customer.CUSTOMER.FIRSTNAME.eq(entity.getFirstname()))
                .and(Customer.CUSTOMER.LASTNAME.eq(entity.getFirstname()))
                .fetchOne(0, Integer.class) > 0;
    }
}
