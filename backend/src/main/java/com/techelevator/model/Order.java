package com.techelevator.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {

    //Order Table
    private int orderId;
    private String status;
    private Timestamp timeStamp;
    private boolean isDelivery;
    private BigDecimal total = new BigDecimal(0);
    List<PizzaOrder> pizzas;

    public List<PizzaOrder> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaOrder> pizzas) {
        this.pizzas = pizzas;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }



}
