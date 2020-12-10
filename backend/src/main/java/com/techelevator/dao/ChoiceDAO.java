package com.techelevator.dao;

import com.techelevator.model.Choice;
import java.util.List;

public interface ChoiceDAO {

    void deleteChoice(int choiceId);

    List<Choice> getAllChoices();

    void addChoice(Choice choice);



}
