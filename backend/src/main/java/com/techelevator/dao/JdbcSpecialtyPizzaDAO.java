package com.techelevator.dao;

import com.techelevator.model.Choice;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSpecialtyPizzaDAO implements SpecialtyPizzaDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcSpecialtyPizzaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<SpecialtyPizza> getAll() {
        List<SpecialtyPizza> result = new ArrayList<>();
        String sql = "SELECT specialty_id, name, description, price, is_available FROM specialty_pizza;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            SpecialtyPizza specialtyPizza = new SpecialtyPizza();
            specialtyPizza.setSpecialtyId(rowSet.getInt("specialty_id"));
            specialtyPizza.setAvailable(rowSet.getBoolean("is_available"));
            specialtyPizza.setName(rowSet.getString("name"));
            specialtyPizza.setPrice(rowSet.getDouble("price"));
            specialtyPizza.setDescription(rowSet.getString("description"));
            result.add(specialtyPizza);

        }
        return result;
    }

    @Override
    public void addSpecial(SpecialtyPizza specialtyPizza) {
        String sql = "INSERT INTO specialty_pizza (name, description, price, is_available) " +
                     "VALUES (?, ?, ?, ?) RETURNING specialty_id;";
        int specialtyId = jdbcTemplate.queryForObject(sql, Integer.class, specialtyPizza.getName(), specialtyPizza.getDescription(), specialtyPizza.getPrice(), specialtyPizza.isAvailable());
        addChoiceSpecial(specialtyPizza.getCrust(), specialtyId);
        addChoiceSpecial(specialtyPizza.getSauce(), specialtyId);
        addToppingsToChoiceSpecial(specialtyPizza.getRegularToppings(), specialtyId);
        addToppingsToChoiceSpecial(specialtyPizza.getPremiumToppings(), specialtyId);
    }

    private void addChoiceSpecial(Choice choice, int specialtyId) {
        String sql = "INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, specialtyId, choice.getChoiceId());
    }

    private void addToppingsToChoiceSpecial(List<Choice> toppings, int specialtyId) {
        for (Choice choice : toppings) {
            addChoiceSpecial(choice, specialtyId);
        }
    }


}
