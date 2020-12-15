package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Test;

public class SpecialtyPizzaDAOTest {

    SpecialtyPizzaDAO specialtyPizzaDAO;

    @Test
    public void getSpecialtyPizzaById() {
        Assert.assertEquals("Veggie Deluxe", specialtyPizzaDAO.getSpecialtyPizzaById(1).getName());
    }

    @Test
    public void getCustomPizzaById() {
        Assert.assertEquals("Custom", specialtyPizzaDAO.getCustomPizzaById(1).getName());
    }
}
