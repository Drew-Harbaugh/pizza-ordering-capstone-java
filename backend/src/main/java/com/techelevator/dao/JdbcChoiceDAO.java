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
        String sql = "SELECT choice_id, category_id, name, is_available FROM choices ORDER BY choice_id;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Choice choice = new Choice();
            choice.setChoiceId(rowSet.getInt("choice_id"));
            choice.setCategoryId(rowSet.getInt("category_id"));
            choice.setName(rowSet.getString("name"));
            choice.setAvailable(rowSet.getBoolean("is_available"));
            result.add(choice);
        }
        return result;
    }

    @Override
    public void addChoice(Choice choice) {
        String sql = "INSERT INTO choices (category_id, name, is_available) VALUES (?,?,?);";
        jdbcTemplate.update(sql, choice.getCategoryId(), choice.getName(), choice.isAvailable());
    }

    @Override
    public Choice getChoiceById(int id) {
        Choice choice = new Choice();
        String sql = "SELECT choice_id FROM choices WHERE id = ?;";
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
