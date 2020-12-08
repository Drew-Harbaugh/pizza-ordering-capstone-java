package com.techelevator.controller;

import com.techelevator.dao.SpecialtyPizzaDAO;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SpecialtyPizzaController {

    private SpecialtyPizzaDAO specialtyPizzaDAO;

    public SpecialtyPizzaController(SpecialtyPizzaDAO specialtyPizzaDAO) {
        this.specialtyPizzaDAO = specialtyPizzaDAO;
    }

    @GetMapping("/specials")
    public List<SpecialtyPizza> getAll() {
        return specialtyPizzaDAO.getAll();
    }

    @PostMapping("/specials")
    public void add(@RequestBody SpecialtyPizza specialtyPizza) {
        specialtyPizzaDAO.addSpecial(specialtyPizza);
    }


}
