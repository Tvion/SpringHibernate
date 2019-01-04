package com.netcracker.model;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "area", nullable = false)
    private String area;
    @Column(name = "discount", nullable = false)
    private int discount;

    public Customer(String lastName, String area, int discount) {
        this.lastName = lastName;
        this.area = area;
        this.discount = discount;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", area='" + area + '\'' +
                ", discount=" + discount +
                '}';
    }
}
