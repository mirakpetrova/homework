package com.example.homework.domain;

import com.example.homework.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(long id,User user);
    void deleteUserById(long id);
    List<User> getAllUsers();
    User getUserById(long id);
}
