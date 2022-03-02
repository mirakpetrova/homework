package com.example.homework.domain;

import com.example.homework.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);
    void updateRestaurant(long id,Restaurant restaurant);
    void deleteRestaurantById(long id);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(long id);
}
