package com.techelevator.dao;

import com.techelevator.model.Choice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcChoiceDAO implements ChoiceDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcChoiceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Choice> getChoiceByCategoryId(int id) {
        List<Choice> result = new ArrayList<>();
        String sql = "SELECT choice_id, category_id, name, is_available FROM choices WHERE category_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
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

}
