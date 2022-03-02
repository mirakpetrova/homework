package com.example.homework.dao;

import com.example.homework.model.Dish;
import com.example.homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {
    Dish findById(long id);

    @Modifying
    @Transactional
    @Query("UPDATE Dish as d SET d.name = :name,d.description = :description,d.url = :url,d.restaurant = :restaurant WHERE id = :id ")
    void updateDish(@Param("id") long id, @Param("name")String name,
                    @Param("description") String description, @Param("url")String url,
                    @Param("restaurant") Restaurant restaurant);
}
