package com.netcracker.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name = "storage", nullable = false)
    private String storage;

    @Column(name = "amount", nullable = false)
    private int amount;

    public Books() {
    }

    public Books(String name, int cost, String storage, int amount) {
        this.name = name;
        this.cost = cost;
        this.storage = storage;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", storage='" + storage + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return cost == books.cost &&
                amount == books.amount &&
                Objects.equals(name, books.name) &&
                Objects.equals(storage, books.storage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, cost, storage, amount);
    }
}
