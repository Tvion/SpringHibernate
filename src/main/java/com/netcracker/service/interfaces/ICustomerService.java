package com.netcracker.service.interfaces;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerService {

    void add(Customer entity);

    List<Customer> findAll();

    Customer findById(int id);

    void deleteById(int id);

    void updateById(int id, Customer entity);

    int getRowCount();

    void showAreas();

    void showNAreaCustomers();
}
