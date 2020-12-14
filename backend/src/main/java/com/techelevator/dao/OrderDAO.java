package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder (Order order);

    List<Order> getOrders ();

    void addPizzaOrder (Order order, int specialtyId, int sizeId);
}
