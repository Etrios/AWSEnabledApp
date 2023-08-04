package com.ganesh.personal.AWSEnabledApp.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name="orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private int quantity;


    // in cents / paise
    private int pricePerItem;



    // Soft reference to the SKU item, in-case that SKU changes in the future.
    // Will not enforce hard reference checks for the same.
    private String SKU;

//    @ManyToOne
//    @JoinColumn(name = "orders_id")
//    @Getter
//    @Setter
//    private Order order;

    public OrderItem() {

    }

    public OrderItem(int quantity, int pricePerItem, String SKU) {
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.SKU = SKU;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pricePerItem=" + pricePerItem +
                ", SKU='" + SKU + '\'' +
//                ", Order Id='" + order.getId() +'\'' +
                '}';
    }
}
