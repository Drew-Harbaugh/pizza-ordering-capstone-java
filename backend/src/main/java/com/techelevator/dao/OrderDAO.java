package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder (Order order);

    List<Order> getAllOrders();

    void updateOrderStatus(Order order);

}
