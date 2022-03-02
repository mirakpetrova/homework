package com.example.homework.domain.impl;

import com.example.homework.dao.OrderRepository;
import com.example.homework.domain.OrderService;
import com.example.homework.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(long id, String status) {
       orderRepository.updateOrder(id,status);
    }

    @Override
    public void deleteOrderById(long id) {
       orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrdersById(long id) {
        return orderRepository.getById(id);
    }

}
