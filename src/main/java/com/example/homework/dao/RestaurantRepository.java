package com.example.homework.dao;

import com.example.homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findById(long id);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant as r SET r.name = :name,r.description = :description,r.url = :url," +
            "r.address = :address WHERE id = :id")
    void updateRestaurant(@Param("id") long id, @Param("name")String name,
                    @Param("description") String description, @Param("url")String url,
                    @Param("address") String address);
}
