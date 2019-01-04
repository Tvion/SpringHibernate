package com.netcracker.service.interfaces;

import com.netcracker.model.Purchase;

import java.util.List;

public interface IPurchaseService {

    void add(Purchase entity);

    List<Purchase> findAll();

    Purchase findById(int id);

    void deleteById(int id);

    void updateById(int id, Purchase entity);

    int getRowCount();

    void showMonths();

    void showCustomerAndShop();

    void showFullInfo();

    void moreThen60000();

    void purchaseWinterHomeArea();

    void exceptAutoWithDiscount();

    void booksHomeStorage();
}
