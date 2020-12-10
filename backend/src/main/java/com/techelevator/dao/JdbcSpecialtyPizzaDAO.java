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
    private JdbcChoiceDAO jdbcChoiceDAO;

    public JdbcSpecialtyPizzaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //SELECT s.specialty_id, s.name, s.description, s.price, s.is_available, c.choice_id
    //FROM specialty_pizza AS s
    //JOIN choices_specialty_pizza AS c ON s.specialty_id = c.specialty_id
    //GROUP BY s.name



    @Override
    public List<SpecialtyPizza> getAll() {
        List<SpecialtyPizza> result = new ArrayList<>();
        List<Choice> regularToppings = new ArrayList<>();
        List<Choice> premiumToppings = new ArrayList<>();
        Choice sauce = new Choice();


        String sql = "SELECT specialty_id, name, description, price, is_available FROM specialty_pizza;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            SpecialtyPizza specialtyPizza = new SpecialtyPizza();
            specialtyPizza.setSpecialtyId(rowSet.getInt("specialty_id"));
            specialtyPizza.setAvailable(rowSet.getBoolean("is_available"));
            specialtyPizza.setName(rowSet.getString("name"));
            specialtyPizza.setPrice(rowSet.getDouble("price"));
            specialtyPizza.setDescription(rowSet.getString("description"));


        String sql1 = "SELECT c.choice_id, c.category_id, c.name, c.is_available, s.name  " +
                "FROM choices AS c " +
                "JOIN choices_specialty_pizza s ON c.choice_id = s.choice_id " +
                "WHERE s.specialty_id = ?;";
//        SqlRowSet choiceRowSet = jdbcTemplate.queryForRowSet(sql1, specia)
        }


        return result;
    }



//            String sqlSauce =
//                    "SELECT s.choice_id, c.name " +
//                    "FROM choices_specialty_pizza AS s " +
//                    "JOIN choices AS c ON s.choice_id = c.choice_id " +
//                    "WHERE s.specialty_id = ? AND c.category_id = 3;";
//            SqlRowSet sauceRowSet = jdbcTemplate.queryForRowSet(sqlSauce, specialtyPizza.getSpecialtyId());
//            if (sauceRowSet.next()) {
//                int id = sauceRowSet.getInt("choice_id");
//                sauce = jdbcChoiceDAO.getChoiceById(id);
//
//                specialtyPizza.setSauce(sauce);
//            }
//
//            String sqlRegular =   "SELECT s.choice_id, c.name " +
//                            "FROM choices_specialty_pizza AS s " +
//                            "JOIN choices AS c ON s.choice_id = c.choice_id " +
//                            "WHERE s.specialty_id = ? AND c.category_id = 4";
//            SqlRowSet rowSet1 = jdbcTemplate.queryForRowSet(sqlRegular, specialtyPizza.getSpecialtyId());
//            while (rowSet1.next()) {
//                Choice regularChoice = new Choice();
//                regularChoice.setChoiceId(rowSet1.getInt("choice_id"));
//                regularChoice.setName(rowSet1.getString("name"));
//                regularToppings.add(regularChoice);
//            }
//
//            String sqlPremium =   "SELECT s.choice_id, c.name " +
//                        "FROM choices_specialty_pizza AS s " +
//                        "JOIN choices AS c ON s.choice_id = c.choice_id " +
//                        "WHERE s.specialty_id = ? AND c.category_id = 5";
//            SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sqlPremium, specialtyPizza.getSpecialtyId());
//            while (rowSet2.next()) {
//                Choice premiumChoice = new Choice();
//                premiumChoice.setChoiceId(rowSet2.getInt("choice_id"));
//                premiumChoice.setName(rowSet2.getString("name"));
//                premiumToppings.add(premiumChoice);
//            }
//
//            specialtyPizza.setRegularToppings(regularToppings);
//            specialtyPizza.setPremiumToppings(premiumToppings);
//
//
//            result.add(specialtyPizza);
//            }
//        return result;
//    }

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
