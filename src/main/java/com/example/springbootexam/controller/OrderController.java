package com.example.springbootexam.controller;
import com.example.springbootexam.model.Order;
import com.example.springbootexam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.OrderList();
    }

    @DeleteMapping("/orders/{orderid}")
    public Optional<Order> deleteOrder(@PathVariable int orderid) {
        return orderService.deleteOrder(orderid);
    }

    @PutMapping("/orders/{orderid}")
    public Optional<Order> updateQuantity(@PathVariable int orderid, @RequestBody int newQuantity) {
        return Optional.ofNullable(orderService.changeQuantity(orderid, newQuantity));
    }
}
/*
    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @GetMapping("/order")
    public List<Order> AllOrder(){
        return orderService.OrderList();
    }
    @DeleteMapping("/order/{orderid}")
    public Optional<Order> DeleteOrder(@PathVariable int orderid){
        return orderService.deleteOrder(orderid);
    }
    @PutMapping("/order/{typecart}")
    public Optional<Order> UpdateTypecart(@PathVariable int newquantity, int quantity){
        return Optional.ofNullable(orderService.changeQuantity(newquantity, quantity));
    }
}*/
