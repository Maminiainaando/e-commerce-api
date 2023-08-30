package com.example.springbootexam.service;

import com.example.springbootexam.model.Review;
import com.example.springbootexam.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.example.springbootexam.model.User;

import java.util.List;
import java.util.Optional;

/* private int id;
    private String username;
    private String email;
    private String work;
    private String password;

    */
@Service
public class UserService {
   private final UserDAO userDAO;
   @Autowired
   public UserService (UserDAO userDAO){
       this.userDAO=userDAO;
   }
    public User createUser(User user){
    return userDAO.insert(user);
}
    public User getUserByWork(String work){
        return userDAO.searchByWork(work);
    }
    public User changeWork(String newwork,String work){
        return  userDAO.updatework(newwork,work);
    }
    public boolean getAllUser(){
        System.out.println(userDAO.findAllUser());
        return false;
    }
    public List<User> deleteByName(String username){
        System.out.println(userDAO.deleteByUsername(username));
        return null;
    }
    public List<User> deleteById(int id){
        System.out.println(userDAO.deleteById(id));
        return null;
    }
    }
