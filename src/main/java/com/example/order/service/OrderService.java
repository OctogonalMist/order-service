package com.example.order.service;

import com.example.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(int theId);

    void save(Order order);

    void deleteById(int theId);
}
