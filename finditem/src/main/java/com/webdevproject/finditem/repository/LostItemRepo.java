package com.webdevproject.finditem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webdevproject.finditem.model.LostItemDetails;

import io.micrometer.common.lang.Nullable;

@Repository
public class LostItemRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public  Integer postLostItem(LostItemDetails lostItem) {
        String sql = "INSERT INTO lostItem (userId, itemName, itemPic, areaFound, pinCode, details) "
        + "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
        lostItem.getUserId(),
        lostItem.getItemName(),
        lostItem.getItemPic(),
        lostItem.getAreaFound(),
        lostItem.getPinCode(), 
        lostItem.getDetails());
    }


    public List<LostItemDetails> findMyPost(String userId) {
        String sql = "Select * from  lostItem where userId = ?";
        System.out.println(userId);
        return jdbcTemplate.query(sql, new RowMapper<LostItemDetails>() {

            @Override
            @Nullable
            public LostItemDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                LostItemDetails lostItemDetails = new LostItemDetails();
                lostItemDetails.setId(rs.getInt("id"));
                lostItemDetails.setUserId(rs.getString("userId"));
                lostItemDetails.setItemName(rs.getString("itemName"));
                lostItemDetails.setItemPic(rs.getString("itemPic"));
                lostItemDetails.setAreaFound(rs.getString("areaFound"));
                lostItemDetails.setPinCode(rs.getString("pinCode"));
                lostItemDetails.setDetails(rs.getString("details"));
                    return lostItemDetails;
            }
            
        }, new Object[]{userId});}


        
    public List<LostItemDetails> findAllPost() {
        String sql = "Select * from  lostItem";
        return jdbcTemplate.query(sql, new RowMapper<LostItemDetails>() {

            @Override
            @Nullable
            public LostItemDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                LostItemDetails lostItemDetails = new LostItemDetails();
                lostItemDetails.setId(rs.getInt("id"));
                lostItemDetails.setUserId(rs.getString("userId"));
                lostItemDetails.setItemName(rs.getString("itemName"));
                lostItemDetails.setItemPic(rs.getString("itemPic"));
                lostItemDetails.setAreaFound(rs.getString("areaFound"));
                lostItemDetails.setPinCode(rs.getString("pinCode"));
                lostItemDetails.setDetails(rs.getString("details"));
                    return lostItemDetails;
            }
            
        });
    }
}
