package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

//public class JdbcPropertyDao {
//    //instance variables
//    private JdbcTemplate jdbcTemplate;
//
//    //constructor
//    public JdbcPropertyDao(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //methods

    //CREATE TABLE properties (
    //	prop_id SERIAL PRIMARY KEY,
    //	owner_id INT NOT NULL REFERENCES users(user_id),
    //	address VARCHAR(100) NOT NULL,
    //	city VARCHAR(50) NOT NULL,
    //	state VARCHAR(50) NOT NULL,
    //	zip VARCHAR(10) NOT NULL,
    //	vacancy BOOLEAN NOT NULL DEFAULT false,
    // 	pending BOOLEAN NOT NULL DEFAULT false,
    //	rent NUMERIC(10,2) NOT NULL,
    //	bedrooms INT NOT NULL,
    //	bathrooms NUMERIC(2,1) NOT NULL

    //mapRowSet
//    private Property mapRowToProperty (SqlRowSet rowSet){
//        Property property = new Property();
//        property.setPropId();
//    }

//}
