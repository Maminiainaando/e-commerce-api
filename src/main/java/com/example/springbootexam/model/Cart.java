package com.example.springbootexam.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Cart{
    private int cartId;
    private String typeCart;
    private String usercart;
    private Client client;
}
