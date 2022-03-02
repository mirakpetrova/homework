package com.example.homework.domain.impl;

import com.example.homework.dao.RestaurantRepository;
import com.example.homework.domain.RestaurantService;
import com.example.homework.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(long id, Restaurant restaurant) {
        restaurantRepository.updateRestaurant(id,
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getUrl(),
                restaurant.getAddress());
    }

    @Override
    public void deleteRestaurantById(long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.getById(id);
    }
}
