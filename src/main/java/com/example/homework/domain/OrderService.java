package com.example.homework.domain;


import com.example.homework.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    void updateOrder(long id,String status);
    void deleteOrderById(long id);
    List<Order> getAllOrders();
    Order getOrdersById(long id);
}
