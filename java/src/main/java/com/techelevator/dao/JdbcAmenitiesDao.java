package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class JdbcAmenitiesDao implements AmenitiesDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAmenitiesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    private Amenities mapRowToAmenities(SqlRowSet rowSet) {
        Amenities amenities = new Amenities();
        amenities.setAmenitiesId(rowSet.getInt("amenities_id"));
        amenities.setPropId(rowSet.getInt("prop_id"));
        amenities.setDishwasher(rowSet.getBoolean("dishwasher"));
        amenities.setCentralAir(rowSet.getBoolean("central_air"));
        amenities.setLaundry(rowSet.getBoolean("laundry"));
        amenities.setPetsAllowed(rowSet.getBoolean("pets_allowed"));

        return amenities;
    }

    @Override
    public List<Amenities> getAmenities() {
        List<Amenities> amenities = new ArrayList<>();
        String sql = "SELECT amenities_id, prop_id, dishwasher, central_air, laundry, pets_allowed from amenities;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                amenities.add(mapRowToAmenities(results));
            }
        } catch(CannotGetJdbcConnectionException e){
                throw new DaoException("Unable to connect to server or database", e);
            }
            return amenities;
        }

    @Override
    public Amenities getAmenitiesByPropId(int propId) {
        Amenities amenities = null;

        String sql = "SELECT amenities_id, prop_id, dishwasher, central_air, laundry, pets_allowed " +
                "FROM amenities " +
                "WHERE prop_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propId);
            if (results.next()) {
                amenities = mapRowToAmenities(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return amenities;
    }

    @Override
    public Amenities getAmenitiesByAmenitiesId(int amenitiesId) {
        Amenities amenities = null;

        String sql = "SELECT amenities_id, prop_id, dishwasher, central_air, laundry, pets_allowed " +
                "FROM amenities " +
                "WHERE amenities_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, amenitiesId);
            if (results.next()) {
                amenities = mapRowToAmenities(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return amenities;
    }

    @Override
    public Amenities createAmenities(Amenities amenities) {
        Amenities newAmenity = null;

        String sql = "INSERT into amenities (prop_id, dishwasher, central_air, laundry, pets_allowed)" +
                "VALUES (?, ?, ?, ?, ?) RETURNING amenities_id;";
        try {
            int newAmenityId = jdbcTemplate.queryForObject(sql, int.class, amenities.getPropId(),
                    amenities.isDishwasher(), amenities.isCentralAir(),
                    amenities.isLaundry(), amenities.isPetsAllowed());

            newAmenity = getAmenitiesByAmenitiesId(newAmenityId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
            return newAmenity;
    }

    @Override
    public Amenities updateAmenities(Amenities amenities) {
        Amenities updatedAmenities = null;
        String sql = "UPDATE amenities SET dishwasher = ?, central_air = ?, laundry = ?, pets_allowed = ? " + "WHERE prop_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, amenities.isDishwasher(), amenities.isCentralAir(),
                    amenities.isLaundry(), amenities.isPetsAllowed(), amenities.getPropId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedAmenities = getAmenitiesByPropId(amenities.getPropId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedAmenities;
    }

}
