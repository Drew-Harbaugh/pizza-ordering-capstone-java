package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;

import java.util.List;

public interface SpecialtyPizzaDAO {

    List<SpecialtyPizza> getAll();

    void addSpecial(SpecialtyPizza specialtyPizza);


}
