package com.techelevator.dao;

import com.techelevator.model.Choice;
import java.util.List;

public interface ChoiceDAO {

    List<Choice> getChoiceByCategoryId(int id);

    List<Choice> getAllChoices();

}
