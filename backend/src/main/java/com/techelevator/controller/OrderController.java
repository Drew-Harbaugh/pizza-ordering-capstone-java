package com.techelevator.controller;

import com.techelevator.dao.OrderDAO;
import com.techelevator.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    private OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @PostMapping("/orders")
    @ResponseStatus (value = HttpStatus.CREATED)
    public void addOrder(@RequestBody Order order) {
        orderDAO.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    @PutMapping("/orders/{orderId}")
    public void updateOrderStatus(@PathVariable int orderId, @RequestBody Order order) {
        orderDAO.updateOrderStatus(order);
    }

}
