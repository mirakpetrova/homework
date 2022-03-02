package com.example.homework.controller;

import com.example.homework.dao.UserRepository;
import com.example.homework.domain.impl.UserServiceImpl;
import com.example.homework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserServiceImpl service = new UserServiceImpl();

    @RequestMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User showUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        return service.getUserById(userId);
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam String email, @RequestParam String password,
                          @RequestParam String telephone, @RequestParam String address) {
        User user = new User(email, password, firstName, lastName, address, telephone);
        service.addUser(user);
        return "Added new user!";
    }
    @PutMapping("/users/update/{id}")
    public String update(@PathVariable String id,@RequestParam String firstName, @RequestParam String lastName,
                       @RequestParam String email, @RequestParam String password,
                       @RequestParam String telephone, @RequestParam String address){

        service.updateUser(Long.parseLong(id),new User(email,password,firstName,lastName,address,telephone));
        return "user updated";
    }
    @DeleteMapping("/users/delete/{id}")
    public void delete(@PathVariable String id){
         service.deleteUserById(Long.parseLong(id));
    }

}
