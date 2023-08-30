package com.example.springbootexam.controller;
import com.example.springbootexam.model.User;
import com.example.springbootexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")  // Ajout de l'annotation pour spécifier le préfixe commun
public class UserController {
    private final UserService userService;  // Ajout du mot clé final

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public boolean getAllUsers() {  // Correction du type de retour, devrait être une liste
        return userService.getAllUser();
    }

    @GetMapping("/users/work/{work}")
    public Optional<User> userByWork(@PathVariable String work) {
        return Optional.ofNullable(userService.getUserByWork(work));
    }

    @PutMapping("/users/work/{work}")
    public User updateUserWork(@PathVariable String work, @RequestBody String newWork) {
        return userService.changeWork(newWork, work);
    }

    @DeleteMapping("/users/name/{username}")
    public List<User> deleteUserByName(@PathVariable String username) {
        return userService.deleteByName(username);
    }

    @DeleteMapping("/users/id/{id}")
    public List<User> deleteUserById(@PathVariable int id) {
        return userService.deleteById(id);
    }
}
/*
public UserController(UserService userService){
    this.userService=userService;
}
@PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/users")
    public boolean getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{work}")
    public Optional<User> clientBywork(String work) {
        return Optional.ofNullable(userService.getUserByWork(work));
    }
    @PutMapping("/users/{work}")

    public User UpdateWork(@PathVariable String newwork, String work) {
        return userService.changeWork(newwork, work);
    }
    @DeleteMapping("/review/{username}")
    public  Optional<User> DeleteUser(@PathVariable String username){
        return userService.deleteByName(username);
    }
    @DeleteMapping("/review/{id}")
    public  Optional<User> DeleteUserbyId(@PathVariable int id){
        return userService.deleteById(id);
    }*/
//}