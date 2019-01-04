package com.netcracker.dao;

import java.util.List;

public interface IDAO<T> {

    void add(T entity);

    List<T> findAll();

    T findById(int id);

    void deleteById(int id);

    void updateById(int id, T entity);

    int getRowCount();
}
