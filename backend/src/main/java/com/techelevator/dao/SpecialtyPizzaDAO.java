package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;

import java.util.List;

public interface SpecialtyPizzaDAO {

    List<SpecialtyPizza> getAll();

    void addSpecial(SpecialtyPizza specialtyPizza);

    void deleteSpecial(int specialtyId);

    void updateSpecial(SpecialtyPizza specialtyPizza);

    SpecialtyPizza getSpecialtyPizzaById(int specialtyId);

    SpecialtyPizza getCustomPizzaById(int pizzaId);

}
