package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.PizzaOrder;

import java.util.List;

public interface OrderDAO {

    void addOrder (Order order);

    List<Order> getOrders ();

//    void addPizzaOrder (Order order);
}
