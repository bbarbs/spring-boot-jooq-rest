package com.jooq.core.repository;

import java.util.List;

/**
 * Generic DAO.
 *
 * @param <T>
 */

public interface IGenericRepository<T> {

    List<T> findAll();

    T findOne(Long id);

    T save(T entity);

    T update(Long id, T entity);

    void deleteById(Long id);
}
