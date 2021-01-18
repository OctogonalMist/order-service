package com.example.order.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "order_name")
    private Long orderNumber;

    @Column(name = "order_date")
    private String orderDate;

    @OneToMany
    private List<OrderGoods> listOfGoods;

    public Order(@NonNull Long orderNumber, String orderDate, List<OrderGoods> listOfGoods) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.listOfGoods = listOfGoods;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(@NonNull Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderGoods> getListOfGoods() {
        return listOfGoods;
    }

    public void setListOfGoods(List<OrderGoods> listOfGoods) {
        this.listOfGoods = listOfGoods;
    }
}
