package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDAO implements OrderDAO {

    private JdbcTemplate jdbcTemplate;
    private ChoiceDAO choiceDAO;
    private SpecialtyPizzaDAO specialtyPizzaDAO;

    public JdbcOrderDAO(JdbcTemplate jdbcTemplate, ChoiceDAO choiceDAO, SpecialtyPizzaDAO specialtyPizzaDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.choiceDAO = choiceDAO;
        this.specialtyPizzaDAO = specialtyPizzaDAO;
    }

    @Override
    public void addOrder(Order order) {
        // posts to orders table
        String sql = "INSERT INTO orders (status, time_stamp, delivery, total) " +
                "VALUES (?, ?, ?, ?) RETURNING order_id;";
        int orderId = jdbcTemplate.queryForObject(sql, Integer.class, order.getStatus(), order.getTimeStamp(), order.isDelivery(), order.getTotal());
        order.setOrderId(orderId);
        // post to delivery information (customer)
        addCustomer(order.getOrderId(), order.getCustomer());
        // post to pizza_orders for as many pizzas in the order
        for (Pizza pizza : order.getCart()) {
            int pizzaId = addPizzaOrder(order.getOrderId(), pizza.getPizza().getSpecialtyId(), pizza.getSize().getChoiceId());
            PizzaOrderDTO pizzaOrderDTO = getPizzaOrderByPizzaId(pizzaId);
            Integer specialtyId = pizzaOrderDTO.getSpecialty_id();
            if (specialtyId == null || specialtyId == 0) {
                // post to choices_custom_pizza for toppings for as many custom pizzas in the order
                // add crust
                addCustomPizzaChoices(pizzaOrderDTO.getPizza_id(), pizza.getPizza().getCrust().getChoiceId());
                // add sauce
                addCustomPizzaChoices(pizzaOrderDTO.getPizza_id(), pizza.getPizza().getSauce().getChoiceId());
                // loop to add regular toppings
                for (Choice topping : pizza.getPizza().getRegularToppings()) {
                    addCustomPizzaChoices(pizzaOrderDTO.getPizza_id(), topping.getChoiceId());
                }
                // loop to add premium toppings
                for (Choice topping : pizza.getPizza().getPremiumToppings()) {
                    addCustomPizzaChoices(pizzaOrderDTO.getPizza_id(), topping.getChoiceId());
                }
            }
        }
    }

    private void addCustomer(int orderId, Customer customer) {
        String sql = "INSERT INTO delivery_information (order_id, name, phone_number, address, credit_card) " +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, orderId, customer.getName(), customer.getPhoneNumber(), customer.getAddress(), customer.getCreditCard());
    }

    private int addPizzaOrder(int orderId, int specialtyId, int sizeId) {
        String sql = "INSERT INTO pizza_orders (order_id, specialty_id, size_id) " +
                "VALUES (?, ?, ?) RETURNING pizza_id;";
        int pizzaId = jdbcTemplate.queryForObject(sql, Integer.class, orderId, specialtyId, sizeId);
        return pizzaId;
    }

    private PizzaOrderDTO getPizzaOrderByPizzaId(int pizzaId) {
        String sql = "SELECT pizza_id, order_id, specialty_id, size_id FROM pizza_orders WHERE pizza_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, pizzaId);
        PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
        rowSet.next();
        pizzaOrderDTO.setPizza_id(rowSet.getInt("pizza_id"));
        pizzaOrderDTO.setOrder_id(rowSet.getInt("order_id"));
        pizzaOrderDTO.setSpecialty_id(rowSet.getInt("specialty_id"));
        pizzaOrderDTO.setSize_id(rowSet.getInt("size_id"));
        return pizzaOrderDTO;
    }

    private void addCustomPizzaChoices(int pizzaId, int choiceId) {
        String sql = "INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, pizzaId, choiceId);
    }

    @Override
    public List<Order> getAllOrders() {
        // get from order table, add to order object
        List<Order> result = new ArrayList<>();
        String sql = "SELECT order_id, status, time_stamp, delivery, total FROM orders ORDER BY order_id;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            Order order = new Order();
            order.setOrderId(rowSet.getInt("order_id"));
            order.setStatus(rowSet.getString("status"));
            order.setTimeStamp(rowSet.getTimestamp("time_stamp"));
            order.setDelivery(rowSet.getBoolean("delivery"));
            order.setTotal(rowSet.getBigDecimal("total"));
            // get from delivery information table and add to customer object within order object
            Customer customer = getDeliveryInformation(order.getOrderId());
            order.setCustomer(customer);
            // get from pizza_order table and create Pizza objects and add to order object
            List<Pizza> cart = getPizzaOrder(order.getOrderId());
            order.setCart(cart);
            result.add(order);
        }
        return result;
    }

    @Override
    public void updateOrderStatus(Order order) {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?;";
        jdbcTemplate.update(sql, order.getStatus(), order.getOrderId());
    }

    private Customer getDeliveryInformation(int orderId) {
        Customer result = new Customer();
        String sql = "SELECT name, phone_number, address, credit_card FROM delivery_information WHERE order_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, orderId);
        if (rowSet.next()) {
            result.setName(rowSet.getString("name"));
            result.setPhoneNumber(rowSet.getLong("phone_number"));
            result.setAddress(rowSet.getString("address"));
            result.setCreditCard(rowSet.getLong("credit_card"));
        }
        return result;
    }

    private List<Pizza> getPizzaOrder(int orderId) {
        List<Pizza> result = new ArrayList<>();
        String sql = "SELECT pizza_id, specialty_id, size_id FROM pizza_orders WHERE order_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, orderId);
        while (rowSet.next()) {
            PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
            pizzaOrderDTO.setPizza_id(rowSet.getInt("pizza_id"));
            pizzaOrderDTO.setSpecialty_id(rowSet.getInt("specialty_id"));
            pizzaOrderDTO.setSize_id(rowSet.getInt("size_id"));
            // for each pizza...
            // create pizza object by getting either custom pizza toppings or getting specialty pizza then toppings
            // get size
            Pizza pizza = new Pizza();
            // set size
            pizza.setSize(choiceDAO.getChoiceById(pizzaOrderDTO.getSize_id()));
            pizza.setPizzaId(pizzaOrderDTO.getPizza_id());
            // set pizza
            if ((Integer)pizzaOrderDTO.getSpecialty_id() == null || pizzaOrderDTO.getSpecialty_id() == 0) {
                pizza.setPizza(specialtyPizzaDAO.getCustomPizzaById(pizzaOrderDTO.getPizza_id()));
            } else {
                pizza.setPizza(specialtyPizzaDAO.getSpecialtyPizzaById(pizzaOrderDTO.getSpecialty_id()));
            }
            result.add(pizza);
        }
        return result;
    }

}
