package com.example.homework.domain.impl;

import com.example.homework.dao.UserRepository;
import com.example.homework.domain.UserService;
import com.example.homework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, User user) {
       userRepository.updateUser(id,user.getEmail(),user.getPassword(),
               user.getFirstName(),user.getLastName(),
               user.getAddress(),user.getTelephone());
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }
}
