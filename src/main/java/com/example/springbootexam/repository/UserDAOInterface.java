package com.example.springbootexam.repository;

import com.example.springbootexam.model.User;

public interface UserDAOInterface {
    User insert(User user);
    boolean findAllUser();
    User updatework(String newwork,String work);
    User searchByWork(String work);
    boolean deleteByUsername(String username);
    boolean deleteById(int id);
}
