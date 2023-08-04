package com.ganesh.personal.AWSEnabledApp.model;

import jakarta.persistence.*;


import java.util.*;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String createdBy;

    private String createdOn;
    //in cents are paise
    private int total;

    private String currency;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "orders_id")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order() {

    }



    public Order(String createdBy, String createdOn, int total, String currency) {
        this.createdOn=createdOn;
        this.createdBy = createdBy;
        this.total = total;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void removeOrderItems() {
        this.orderItems.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdOn + '\'' +
                ", total=" + total +
                ", currency='" + currency + '\'' +
//                ", orderItems=" + orderItems +
                '}';
    }
}
