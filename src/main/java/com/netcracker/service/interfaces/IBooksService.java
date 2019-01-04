package com.netcracker.service.interfaces;

import com.netcracker.model.Books;

import java.util.List;

public interface IBooksService {
    void add(Books entity);

    List<Books> findAll();

    Books findById(int id);

    void deleteById(int id);

    void updateById(int id, Books entity);

    int getRowCount();

    void showUniqueBooks();

    void showWindowsAndExpensiveBooks();

}
