package com.example.springbootexam.service;

import com.example.springbootexam.model.Order;
import com.example.springbootexam.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    public final OrderDAO orderDAO;
    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public Order addOrder(Order order){
        return orderDAO.insert(order);
    }
    public List<Order> OrderList(){
        return orderDAO.findAllOrder();
    }
    public Order changeQuantity(int newquantity,int oldquantity){
        return  orderDAO.updatequantity(newquantity,oldquantity);
    }
    public Optional<Order> deleteOrder(int orderid){
        System.out.println(orderDAO.deleteOrder(orderid));
        return null;
    }
}
