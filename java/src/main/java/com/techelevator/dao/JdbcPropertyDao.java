package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDAO {

    //instance variables
    @Autowired
    private PropertyDAO propertyDAO;

    private JdbcTemplate jdbcTemplate;

    //constructor
    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //methods

    // POV: prop own/mgr logs in to view multiple props
    @Override
    public List<Property> getProperties() {
        List<Property> listofMultiProps = new ArrayList<>();
        String sql = "SELECT prop_id, address, city, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '|') \n" +
                "FROM properties JOIN images USING(prop_id) JOIN amenities USING(prop_id)\n" +
                "GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()) {
                listofMultiProps.add(mapRowToProperty(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Property not found.", e);
        }

        return listofMultiProps;
    }

    //POV: prop own/mgr login for specific prop
    @Override
    public List<Property> getPropertyByOwnerId(int ownerId) {
        List<Property> listofOwnedProps = new ArrayList<>();
        String sql = "\"SELECT prop_id, address, city, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '|') \\n\" +\n" +
                "\"FROM properties JOIN images USING(prop_id) JOIN amenities USING(prop_id)\\n\" +\n" +
                "\"GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed\\n\" +\n" +
                "\"WHERE owner_id = ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, ownerId);

            while (rowSet.next()) {
                listofOwnedProps.add(mapRowToProperty(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("Property not found. :(", e);
        }

        return listofOwnedProps;
    }

    //POV: specific property for tenant login
    @Override
    public Property getPropertyById(int propId) {
        Property oneProp = null;
        String sql = "\"SELECT prop_id, address, city, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '|') \\n\" +\n" +
                "\"FROM properties JOIN images USING(prop_id) JOIN amenities USING(prop_id)\\n\" +\n" +
                "\"GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed\\n\" +\n" +
                "\"WHERE prop_id = ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, propId);
            if (rowSet.next()) {
                oneProp = mapRowToProperty(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("Property not found. :(", e);
        }

        return oneProp;
    }

    //mapRowSet
    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropId(rowSet.getInt("prop_id"));
       // property.setOwnerId(rowSet.getInt("owner_id"));
        property.setAddress(rowSet.getString("address"));
        property.setCity(rowSet.getString("city"));
        property.setState(rowSet.getString("state"));
        property.setZipCode(rowSet.getInt("zip"));
        property.setVacancy(rowSet.getBoolean("vacancy"));
        property.setPending((rowSet.getBoolean("pending")));
        property.setRent(rowSet.getDouble("rent"));
        property.setBedrooms(rowSet.getInt("bedrooms"));
        property.setBathrooms(rowSet.getDouble("bathrooms"));
//        if (rowSet.getString("string_agg") != null){
//            property.setImgString(rowSet.getString("string_agg").split("|"));
//        }

        //before you set it turn it into an array of string
        return property;
    }
}


