package com.netcracker.service;

import com.netcracker.dao.IDAO;
import com.netcracker.model.Books;
import com.netcracker.service.interfaces.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Comparator.comparing;

@Service("booksService")
public class BooksService implements IBooksService {
    @Autowired
    @Qualifier("booksDao")
    IDAO dao;

    @Override
    public void add(Books entity) {
        dao.add(entity);
    }

    @Override
    public List<Books> findAll() {
        return dao.findAll();
    }

    @Override
    public Books findById(int id) {
        return (Books) dao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateById(int id, Books entity) {
        dao.updateById(id, entity);
    }

    @Override
    public int getRowCount() {
        return dao.getRowCount();
    }

    public void showUniqueBooks() {
        List<Books> books = findAll();
        HashSet<Books> result = new HashSet<>();
        result.addAll(books);
        System.out.println("Unique Books:");
        result.forEach(book -> {
            System.out.print("Book name= " + book.getName());
            System.out.println(" with price= " + book.getCost());
        });
        System.out.println();
    }

    @Override
    public void showWindowsAndExpensiveBooks() {
        List<Books> books = findAll();
        List<Books> targetBooks = new ArrayList<>();
        books.forEach(book -> {
            if (book.getName().toLowerCase().contains("windows") || book.getCost() > 20000) {
                targetBooks.add(book);
            }
        });
        targetBooks.sort(comparing(Books::getName).thenComparing(comparing(Books::getCost).reversed()));
        System.out.println("Windows or Expensive books:");
        targetBooks.forEach(book -> {
            System.out.print("Book name= " + book.getName());
            System.out.println(", price= " + book.getCost());
        });
        System.out.println();
    }
}
