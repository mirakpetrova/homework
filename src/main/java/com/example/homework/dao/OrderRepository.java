package com.example.homework.dao;


import com.example.homework.model.Order;
import com.example.homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findById(long id);

    @Modifying
    @Transactional
    @Query("UPDATE Order as o SET o.status = :status WHERE id = :id ")
    void updateOrder(@Param("id") long id, @Param("status") String status);

}
