package com.example.order.service;

import com.example.order.dao.OrderRepository;
import com.example.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int theId) {
        Optional<Order> result = orderRepository.findById(theId);
        Order order;
        if (result.isPresent()) {
            order = result.get();
        } else {
            throw new RuntimeException("Did not find order id - " + theId);
        }
        return order;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }


    @Override
    public void deleteById(int theId) {
        orderRepository.deleteById(theId);
    }
}
