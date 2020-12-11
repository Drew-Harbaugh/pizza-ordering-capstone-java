package com.techelevator.controller;

import com.techelevator.dao.ChoiceDAO;
import com.techelevator.model.Choice;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ChoicesController {

    private ChoiceDAO choiceDAO;

    public ChoicesController(ChoiceDAO choiceDAO) {
        this.choiceDAO = choiceDAO;
    }

    @GetMapping("/choices")
    public List<Choice> getAll() {
        return choiceDAO.getAllChoices();
    }

    @PostMapping("/choices")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addChoice(@RequestBody Choice choice) {
        choiceDAO.addChoice(choice);
    }

    @DeleteMapping("/choices/{choiceId}")
    public void deleteChoice(@PathVariable int choiceId){
        if (!choiceDAO.deleteChoice(choiceId)) {
            throw new ResponseStatusException(HttpStatus.LOCKED);
        }
    }

    @PutMapping("/choices/{choiceId}")
    public void update(@PathVariable int choiceId, @RequestBody Choice choice){choiceDAO.update(choice);}

}


