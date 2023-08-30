package com.example.springbootexam.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order{
    private int orderId;
    private Client client;
    private Date orderDate;
    private Boolean offlineorder;
    private List<Product> productList;
    private int quantity;
    private float unitPrice;
}
