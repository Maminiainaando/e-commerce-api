package com.example.springbootexam.repository;

import com.example.springbootexam.model.Order;

import java.util.List;

public interface OrderDAOInterface {
    Order insert(Order order);
    List<Order> findAllOrder();
    Order updatequantity(int newquantity, int quantity);
   boolean deleteOrder(int orderid);
}