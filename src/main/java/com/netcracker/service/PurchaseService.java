package com.netcracker.service;

import com.netcracker.dao.IDAO;
import com.netcracker.model.Books;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.interfaces.IBooksService;
import com.netcracker.service.interfaces.ICustomerService;
import com.netcracker.service.interfaces.IPurchaseService;
import com.netcracker.service.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService {
    @Autowired
    @Qualifier("purchaseDao")
    IDAO dao;

    @Autowired
    IShopService shopService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IBooksService booksService;

    @Override
    public void add(Purchase entity) {
        int cost = booksService.findById(entity.getBook()).getCost();
        entity.setCost(cost * entity.getAmount());
        dao.add(entity);
    }

    @Override
    public List<Purchase> findAll() {
        return dao.findAll();
    }

    @Override
    public Purchase findById(int id) {
        return (Purchase) dao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateById(int id, Purchase entity) {
        dao.updateById(id, entity);
    }

    @Override
    public int getRowCount() {
        return dao.getRowCount();
    }

    public void showMonths() {
        List<Purchase> purchases = findAll();
        Set<Integer> months = new HashSet<>();

        purchases.forEach(purchase -> {
            months.add(purchase.getDate().getMonth());
        });

        System.out.println("Months:");
        months.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showCustomerAndShop() {
        List<Purchase> purchases = findAll();
        System.out.println("Purchases:");

        purchases.forEach(purchase -> {

            String customerLastName = customerService.findById(purchase.getCustomer()).getLastName();
            String shopName = shopService.findById(purchase.getSeller()).getShopName();
            System.out.print("Customer lastname = " + customerLastName);
            System.out.println(", shop name = " + shopName);

        });
        System.out.println();
    }

    @Override
    public void showFullInfo() {
        List<Purchase> purchases = findAll();
        System.out.println("Purchases:");

        purchases.forEach(purchase -> {

            Customer customer = customerService.findById(purchase.getCustomer());
            String customerLastName = customer.getLastName();
            String bookName = booksService.findById(purchase.getBook()).getName();
            Date date = purchase.getDate();
            int discount = customer.getDiscount();
            int amount = purchase.getAmount();

            System.out.print("Date = " + date);
            System.out.print(", customer lastname = " + customerLastName);
            System.out.print(", discount = " + discount);
            System.out.print(", book name = " + bookName);
            System.out.println(", amount = " + amount);

        });
        System.out.println();
    }

    @Override
    public void moreThen60000() {
        List<Purchase> purchases = findAll();
        System.out.println("Purchases more then 60000:");

        purchases.forEach(purchase -> {

            if (purchase.getCost() < 60000) return;

            Customer customer = customerService.findById(purchase.getCustomer());
            String customerLastName = customer.getLastName();
            Date date = purchase.getDate();

            System.out.print("Date = " + date);
            System.out.print(", customer lastname = " + customerLastName);
            System.out.println(", order id = " + purchase.getId());

        });
        System.out.println();
    }

    @Override
    public void purchaseWinterHomeArea() {
        List<Purchase> purchases = findAll();
        List<String> result = new ArrayList<>();

        purchases.forEach(purchase -> {


            if (purchase.getDate().getMonth() > 5) return;

            Customer customer = customerService.findById(purchase.getCustomer());
            String customerArea = customer.getArea();
            String shopArea = shopService.findById(purchase.getSeller()).getArea();

            if (!shopArea.equals(customerArea)) return;

            String customerLastName = customer.getLastName();
            Date date = purchase.getDate();
            String resultString = "Customer lastName = " + customerLastName + ", area = " + customerArea + ", date = " + date;
            result.add(resultString);

        });

        System.out.println("Purchases until spring in home area:");
        result.sort(Comparator.comparing(x -> x));
        result.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void exceptAutoWithDiscount() {
        List<Purchase> purchases = findAll();
        System.out.println("Shops except Autozavodskiy:");

        purchases.forEach(purchase -> {


            Shop shop = shopService.findById(purchase.getSeller());
            String shopArea = shop.getArea();

            if (shopArea.equals("Autozavodskiy")) return;

            Customer customer = customerService.findById(purchase.getCustomer());
            int discount = customer.getDiscount();
            if (discount < 10 || discount > 15) return;
            System.out.println(shop);
        });
        System.out.println();
    }

    @Override
    public void booksHomeStorage() {
        List<Purchase> purchases = findAll();
        List<Books> books = new ArrayList<>();

        purchases.forEach(purchase -> {


            Books book = booksService.findById(purchase.getBook());
            String shopArea = shopService.findById(purchase.getSeller()).getArea();
            String bookStorage = book.getStorage();
            int amount = book.getAmount();

            if (!shopArea.equals(bookStorage) || amount <= 10) return;

            books.add(book);

        });
        books.sort(Comparator.comparing(Books::getCost));

        System.out.println("Books from the same area storage:");

        books.forEach(System.out::println);
        System.out.println();
    }
}
