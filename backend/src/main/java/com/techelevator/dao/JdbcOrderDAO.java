package com.techelevator.dao;

import com.techelevator.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDAO implements OrderDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (status, time_stamp, delivery, total) " +
                        "VALUES (?, ?, ?, ?) RETURNING order_id;";
        int orderId = jdbcTemplate.queryForObject(sql, Integer.class, order.getStatus(), order.getTimeStamp(), order.isDelivery(), order.getTotal());
        order.setOrderId(orderId);
    }

    @Override
    public List<Order> getOrders() {
        List<Order> result = new ArrayList<>();
        String sql = "SELECT order_id, status, time_stamp, delivery, total FROM orders;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);


        while(rowSet.next()) {
            Order order = new Order();
            order.setOrderId(rowSet.getInt("order_id"));
            order.setStatus(rowSet.getString("status"));
            order.setTimeStamp(rowSet.getTimestamp("time_stamp"));
            order.setDelivery(rowSet.getBoolean("delivery"));
            order.setTotal(rowSet.getBigDecimal("total"));
            String sql1 = "SELECT pizza_id, specialty_id, size_id FROM pizza_orders WHERE order_id = ?";
            SqlRowSet rowSet1 = jdbcTemplate.queryForRowSet(sql1, rowSet.getInt("order_id"));
//            while (rowSet1.next()) {
//                order.setPizzaId(rowSet1.getInt("pizza_id"));
//                order.setSpecialtyId(rowSet1.getInt("specialty_id"));
//                order.setSizeId(rowSet1.getInt("size_id"));
//                result.add(order);
//            }
        }

        return result;
    }

    @Override
    public void addPizzaOrder(Order order, int specialtyId, int sizeId) {
        String sql = "INSERT INTO pizza_orders (order_id, specialty_id, size_id) " +
                "VALUES (?, ?, ?) RETURNING pizza_id;";
       int pizzaId = jdbcTemplate.queryForObject(sql, Integer.class, order.getOrderId(), specialtyId, sizeId);

    }


}
