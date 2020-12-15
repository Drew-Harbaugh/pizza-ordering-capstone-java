package com.techelevator.dao;

import com.techelevator.model.Choice;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcChoiceDAO implements ChoiceDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcChoiceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean deleteChoice(int choiceId){
        try {
            String sql = "DELETE FROM choices WHERE choice_id = ?;";
            jdbcTemplate.update(sql, choiceId);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public List<Choice> getAllChoices() {
        List<Choice> result = new ArrayList<>();
        String sql = "SELECT c.choice_id, c.category_id, c.name, c.is_available, s.specialty_price, s.custom_price " +
                    "FROM choices AS c LEFT JOIN size_price AS s ON s.choice_id = c.choice_id ORDER BY choice_id;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Choice choice = new Choice();
            choice.setChoiceId(rowSet.getInt("choice_id"));
            choice.setCategoryId(rowSet.getInt("category_id"));
            choice.setName(rowSet.getString("name"));
            choice.setAvailable(rowSet.getBoolean("is_available"));
            if (rowSet.getBigDecimal("custom_price") != null) {
                choice.setCustomPrice(rowSet.getBigDecimal("custom_price"));
            }
            if (rowSet.getBigDecimal("specialty_price") != null) {
                choice.setSpecialtyPrice(rowSet.getBigDecimal("specialty_price"));
            }
            result.add(choice);
        }
        return result;
    }

    @Override
    public void addChoice(Choice choice) {
        String sql = "INSERT INTO choices (category_id, name, is_available) VALUES (?,?,?) RETURNING choice_id;";
        Integer choiceId = jdbcTemplate.queryForObject(sql, Integer.class, choice.getCategoryId(), choice.getName(), choice.isAvailable());
        if (choice.getCategoryId() == 1){
            String sizePriceSQL = "INSERT INTO size_price (choice_id, specialty_price, custom_price) VALUES (?,?,?);";
            jdbcTemplate.update(sizePriceSQL, choiceId, choice.getSpecialtyPrice(), choice.getCustomPrice());
        }
    }

    @Override
    public Choice getChoiceById(int id) {
        Choice choice = new Choice();
        String sql = "SELECT choice_id, category_id, name, is_available FROM choices WHERE choice_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        while (rowSet.next()) {
            choice.setChoiceId(rowSet.getInt("choice_id"));
            choice.setCategoryId(rowSet.getInt("category_id"));
            choice.setName(rowSet.getString("name"));
            choice.setAvailable(rowSet.getBoolean("is_available"));
        }
        return choice;
    }

    @Override
    public void update(Choice choice){
        String sql = "UPDATE choices SET category_id = ?, name = ?, is_available = ? WHERE choice_id = ?;";
        jdbcTemplate.update(sql, choice.getCategoryId(), choice.getName(), choice.isAvailable(), choice.getChoiceId());
    }

}
