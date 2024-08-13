package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Images;
import com.techelevator.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Autowired
    private AmenitiesDao amenitiesDao;

    private JdbcTemplate jdbcTemplate;

    //constructor
    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //GET methods

    // POV: prop own/mgr logs in to view multiple props
    @Override
    public List<Property> getProperties() {
        List<Property> listofMultiProps = new ArrayList<>();
        String sql = "SELECT prop_id, address, city, owner_id, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '|')\n" +
                " FROM properties\n" +
                " JOIN images USING(prop_id)\n" +
                " JOIN amenities USING(prop_id)\n" +
                " JOIN users ON users.user_id = properties.owner_id\n" +
                " GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()) {
                listofMultiProps.add(mapRowToProperty(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Properties not found.", e);
        }

        return listofMultiProps;
    }

    //POV: prop own/mgr login for specific prop
    @Override
    public List<Property> getPropertiesByOwnerId(int ownerId) {
        List<Property> listofOwnedProps = new ArrayList<>();
        String sql = "SELECT prop_id, address, city, owner_id, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '|')\n" +
                "FROM properties JOIN images USING(prop_id) JOIN amenities USING(prop_id) JOIN users ON users.user_id = properties.owner_id\n" +
                "WHERE owner_id = ?\n" +
                "GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, ownerId);

            while (rowSet.next()) {
                listofOwnedProps.add(mapRowToProperty(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Properties not found.", e);
        }

        return listofOwnedProps;
    }

    //POV: specific property for general user login
    @Override
    public Property getPropertyByPropId(int propId) {
        Property oneProp = null;
        String sql = "SELECT prop_id, address, city, owner_id, state, zip, vacancy, pending, rent, bedrooms, bathrooms, dishwasher, central_air, laundry, pets_allowed, string_agg(img_url, '\\|')\n" +
                " FROM properties JOIN images USING(prop_id) JOIN amenities USING(prop_id) JOIN users ON users.user_id = properties.owner_id " +
                " WHERE prop_id = ?\n" +
                " GROUP BY prop_id, dishwasher, central_air, laundry, pets_allowed;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, propId);
            if (rowSet.next()) {
                oneProp = mapRowToProperty(rowSet);
            } else{
                throw new DaoException("Property not found.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return oneProp;
    }

    //POST methods
    @Override
    public Property createProperty(Property property, Amenities amenities, Images images) {
        Property createProp = null;

        String sql = "INSERT INTO properties (owner_id, address, city, state, zip, " +
                                             "vacancy, pending, rent, bedrooms, bathrooms)\n" +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
        "RETURNING prop_id";

        String sql2 =
        "INSERT INTO amenities (prop_id, dishwasher, central_air, laundry, pets_allowed)\n" +
        "VALUES (?, ?, ?, ?, ?)";

        String sql3 =
                "INSERT INTO images (prop_id, img_url) VALUES (?,?)";

        try {
            int newPropId =
                    jdbcTemplate.queryForObject(sql, int.class,
                    property.getOwnerId(),
                    property.getAddress(),
                    property.getCity(),
                    property.getState(),
                    property.getZipCode(),
                    property.isVacancy(),
                    property.isPending(),
                    property.getRent(),
                    property.getBedrooms(),
                    property.getBathrooms());

            jdbcTemplate.update(sql2,
                    newPropId,
                    amenities.isDishwasher(),
                    amenities.isCentralAir(),
                    amenities.isLaundry(),
                    amenities.isPetsAllowed());

            jdbcTemplate.update(sql3,
                    newPropId,
                    images.getImageURL());

            createProp = getPropertyByPropId(newPropId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return createProp;
    }

    //PUT methods
    //POV: prop mgr/ownr is able to update prop by prop id
    @Override
    public Property updatePropByPropId(Property property, Amenities amenities, Images images){
        Property updatedProp = null;
        int propId = property.getPropId();

        String sql = "UPDATE properties\n" +
                    "SET address = ?, city = ?, state = ?, zip = ?, vacancy = ?, pending = ?, rent = ?, bedrooms = ?, bathrooms = ? \n" +
                    "WHERE prop_id = ?;";

        String sql2 = "UPDATE amenities \n" +
                    "SET dishwasher = ?, central_air = ?, laundry = ?, pets_allowed = ? \n" +
                    "WHERE prop_id = ?;";

        String sql3 = "UPDATE images\n" +
                    "SET img_url = ? \n" +
                    "WHERE prop_id = ?;";


        try {
            int RowsAffected = jdbcTemplate.update(sql,
                            property.getAddress(),
                            property.getCity(),
                            property.getState(),
                            property.getZipCode(),
                            property.isVacancy(),
                            property.isPending(),
                            property.getRent(),
                            property.getBedrooms(),
                            property.getBathrooms(),
                            propId);

            jdbcTemplate.update(sql2,
                    amenities.isDishwasher(),
                    amenities.isCentralAir(),
                    amenities.isLaundry(),
                    amenities.isPetsAllowed(),
                    propId);

            jdbcTemplate.update(sql3,
                    images.getImageURL(),
                    propId);

            if (RowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedProp = getPropertyByPropId(propId);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedProp;
    }

    //mapRowSet
    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropId(rowSet.getInt("prop_id"));
        property.setOwnerId(rowSet.getInt("owner_id"));
        property.setAddress(rowSet.getString("address"));
        property.setCity(rowSet.getString("city"));
        property.setState(rowSet.getString("state"));
        property.setZipCode(rowSet.getString("zip"));
        property.setVacancy(rowSet.getBoolean("vacancy"));
        property.setPending((rowSet.getBoolean("pending")));
        property.setRent(rowSet.getDouble("rent"));
        property.setBedrooms(rowSet.getInt("bedrooms"));
        property.setBathrooms(rowSet.getDouble("bathrooms"));
        property.setDishwasher(rowSet.getBoolean("dishwasher"));
        property.setCentralAir(rowSet.getBoolean("central_air"));
        property.setLaundry(rowSet.getBoolean("laundry"));
        property.setPetsAllowed(rowSet.getBoolean("pets_allowed"));
        if (rowSet.getString("string_agg") != null){
            property.setImgString(rowSet.getString("string_agg").split("\\|"));
        }
        return property;
    }
}


