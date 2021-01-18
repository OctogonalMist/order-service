package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.entity.OrderGoods;
import com.example.order.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        Order order = orderService.findById(orderId);
        // create goods service to make http call to goods microservice for retrieval of Goods by ids
//        oderService.findByIds(List<String> goodsIds);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8181/goods");
        order.getListOfGoods().stream().map(OrderGoods::getGoodId).collect(Collectors.toList());
//        OrderDTO =  Order + Good
        if (order == null) {
            throw new RuntimeException("Order id not found - " + orderId);
        }
        return order;
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order) {
        order.setId(0);
        orderService.save(order);
        return order;
    }

    @PutMapping("/")
    public Order updateOrder(@RequestBody Order order) {
        orderService.save(order);
        return order;
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        Order goods = orderService.findById(orderId);
        if (goods == null) {
            throw new RuntimeException("Order id not found - " + orderId);
        }
        orderService.deleteById(orderId);
        return "Deleted order id - " + orderId;
    }
}
