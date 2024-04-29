package com.webdevproject.finditem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webdevproject.finditem.model.User;

import io.micrometer.common.lang.Nullable;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<User> getAllUsers() {
        String sql = "Select * from  Users";
        return jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            @Nullable
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setPincode(rs.getString("pincode"));
                
                    return user;
            }
            
        });
    }

    public  Integer addUser(User user) {
        System.out.println("inside adduser");
        String sql = "INSERT INTO Users (name, userName, address, password, pincode) "
        + "VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
        user.getName(),
        user.getUserName(),
        user.getAddress(),
        user.getPassword(), 
        user.getPincode());
    }

    public  Integer findByUserEmail(Object email) {
        String sql = "Select count(*) from  Users where email = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,email);
    }

    public User findUserById(String userId) {
        String sql = "Select * from  Users where userId = ?";
        System.out.println(userId);
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }

    public  Integer updateUser(User user) {
        System.out.println(user.getId());
        String sql = "UPDATE Users SET "
                   + "userName = ?, "
                   + "password = ?, "
                   + "name = ?, "
                   + "address = ?, "
                   + "pincode = ? "
                   + "WHERE userId = ?";

        return jdbcTemplate.update(sql, 
            user.getUserName(), 
            user.getPassword(),
            user.getName(), 
            user.getAddress(),
            user.getPincode(),
            user.getId());
    }

    public Integer findByUserId(int userId) {

        String sql = "Select count(*) from  Users where userId = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,userId);
    }

    public Integer authenticate(String userName, String password) {
        System.out.println("userId " +userName + "pass " +password);
        String sql = "Select count(*) from  Users where userName = ? and password = ?";
         Integer r = jdbcTemplate.queryForObject(sql,Integer.class,userName,password);
            System.out.println(r);
         return r;
    }
    public Integer getUserId(String userName, String password) {
        String sql = "Select userId from  Users where userName = ? and password = ?";
         Integer r = jdbcTemplate.queryForObject(sql,Integer.class,userName,password);
            System.out.println(r);
         return r;
    }


 
    
}
