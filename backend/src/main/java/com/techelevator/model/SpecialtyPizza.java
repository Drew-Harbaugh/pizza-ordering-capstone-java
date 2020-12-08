package com.techelevator.model;

import java.util.List;

public class SpecialtyPizza {

    private int specialtyId;
    private String name;
    private String description;
    private boolean isAvailable;
    private double price;
    private Choice crust;
    private Choice size;
    private Choice sauce;
    private List<Choice> regularToppings;
    private List<Choice> premiumToppings;

    public Choice getCrust() {
        return crust;
    }

    public void setCrust(Choice crust) {
        this.crust = crust;
    }

    public Choice getSize() {
        return size;
    }

    public void setSize(Choice size) {
        this.size = size;
    }

    public Choice getSauce() {
        return sauce;
    }

    public void setSauce(Choice sauce) {
        this.sauce = sauce;
    }

    public List<Choice> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<Choice> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<Choice> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<Choice> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
