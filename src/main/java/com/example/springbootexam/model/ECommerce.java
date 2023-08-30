package com.example.springbootexam.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class ECommerce {
    private List<Product> products;
    private List<User> users;
}
