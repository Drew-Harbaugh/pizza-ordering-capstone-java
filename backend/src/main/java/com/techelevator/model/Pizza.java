package com.techelevator.model;

public class Pizza {

    private SpecialtyPizza specialtyPizza;
    private Choice size;

    public SpecialtyPizza getSpecialtyPizza() {
        return specialtyPizza;
    }

    public void setSpecialtyPizza(SpecialtyPizza specialtyPizza) {
        this.specialtyPizza = specialtyPizza;
    }

    public Choice getSize() {
        return size;
    }

    public void setSize(Choice size) {
        this.size = size;
    }
}
