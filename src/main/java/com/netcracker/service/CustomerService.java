package com.netcracker.service;

import com.netcracker.dao.IDAO;
import com.netcracker.model.Customer;
import com.netcracker.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("customerService")
public class CustomerService implements ICustomerService {

    @Autowired
    @Qualifier("customerDao")
    IDAO IDAO;


    @Override
    public void add(Customer entity) {
        IDAO.add(entity);
    }

    @Override
    public List<Customer> findAll() {
        return IDAO.findAll();
    }

    @Override
    public Customer findById(int id) {
        return (Customer) IDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        IDAO.deleteById(id);
    }

    @Override
    public void updateById(int id, Customer entity) {
        IDAO.updateById(id, entity);
    }

    @Override
    public int getRowCount() {
        return IDAO.getRowCount();
    }

    public void showAreas() {
        Set<String> areas = new HashSet<>();
        List<Customer> customers = findAll();
        customers.forEach(customer -> {
            areas.add(customer.getArea());
        });
        System.out.println("Areas:");
        areas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showNAreaCustomers() {
        List<Customer> customers = findAll();
        List<Customer> targetCustomers = new ArrayList<>();
        customers.forEach(customer -> {
            if (customer.getArea().equals("Nizhegorodskiy")) {
                targetCustomers.add(customer);
            }
        });
        System.out.println("Nizhegorodskiy customers and them discounts:");
        targetCustomers.forEach(customer -> {
            System.out.print("Lastname= " + customer.getLastName());
            System.out.println(", discount= " + customer.getDiscount());
        });
        System.out.println();
    }
}
