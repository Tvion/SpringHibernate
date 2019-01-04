package com.netcracker.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "seller", nullable = false)
    private int seller;

    @Column(name = "customer", nullable = false)
    private int customer;

    @Column(name = "book", nullable = false)
    private int book;

    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "cost", nullable = false)
    private int cost;

    public Purchase() {
    }

    public Purchase(Date date, int seller, int customer, int book, int amount, int cost) {
        this.date = date;
        this.seller = seller;
        this.customer = customer;
        this.book = book;
        this.amount = amount;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date=" + date +
                ", seller=" + seller +
                ", customer=" + customer +
                ", book=" + book +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
