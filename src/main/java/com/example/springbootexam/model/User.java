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
public class User {
    private int id;
    private String username;
    private String email;
    private String work;
    private String password;
}
