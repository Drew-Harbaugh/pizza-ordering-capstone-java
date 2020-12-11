package com.techelevator.dao;

import com.techelevator.model.Choice;
import java.util.List;

public interface ChoiceDAO {

    boolean deleteChoice(int choiceId);

    List<Choice> getAllChoices();

    void addChoice(Choice choice);

    Choice getChoiceById(int id);

    void update(Choice choice);

}
