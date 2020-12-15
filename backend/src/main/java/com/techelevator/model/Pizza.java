package com.techelevator.model;

public class Pizza {

    private SpecialtyPizza pizza;
    private Choice size;

    public SpecialtyPizza getPizza() {
        return pizza;
    }

    public void setPizza(SpecialtyPizza pizza) {
        this.pizza = pizza;
    }

    public Choice getSize() {
        return size;
    }

    public void setSize(Choice size) {
        this.size = size;
    }
}
