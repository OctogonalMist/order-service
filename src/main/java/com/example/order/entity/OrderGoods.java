package com.example.order.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "good_id")
    private String goodId;

    public OrderGoods() {
    }

    public OrderGoods(String id, String goodId) {
        this.id = id;
        this.goodId = goodId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
