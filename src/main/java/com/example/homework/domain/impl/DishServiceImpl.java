package com.example.homework.domain.impl;

import com.example.homework.dao.DishRepository;
import com.example.homework.domain.DishService;
import com.example.homework.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("dishService")
public class DishServiceImpl implements DishService {
    private final DishRepository  dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.dishRepository = repository;
    }

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }


    @Override
    public void updateDish(long id, Dish dish) {
        Dish dishToUpdate = dishRepository.findById(id);
        dishRepository.updateDish(
                id,dish.getName(),
                dish.getDescription(),
                dish.getUrl(),
                dish.getRestaurant());
    }

    @Override
    public void deleteDishById(long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(long id) {
        return dishRepository.getById(id);
    }

}
