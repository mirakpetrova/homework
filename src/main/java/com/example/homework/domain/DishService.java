package com.example.homework.domain;

import com.example.homework.model.Dish;

import java.util.List;

public interface DishService {
    void addDish(Dish dish);
    void updateDish(long id,Dish dish);
    void deleteDishById(long id);
    List<Dish> getAllDishes();
    Dish getDishById(long id);
}
