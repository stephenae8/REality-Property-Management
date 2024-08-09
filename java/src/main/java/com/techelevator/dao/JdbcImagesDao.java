package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Images;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcImagesDao implements ImagesDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcImagesDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Images> getImages() {
        List<Images> images = new ArrayList<>();
        String sql = "SELECT img_id, prop_id, img_url FROM images;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                images.add(mapRowToImages(results));
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return images;
    }

    @Override
    public Images getImagesById(int imageId) {
         Images images = null;

        String sql = "SELECT img_id, prop_id, img_url " +
                "FROM images " +
                "WHERE img_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, imageId);
            if (results.next()) {
                images = mapRowToImages(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return images;
    }

    @Override
    public Images getImagesByPropId(int propId) {
        Images images = null;

        String sql = "SELECT img_id, prop_id, img_url " +
                "FROM images " +
                "WHERE prop_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propId);
            if (results.next()) {
                images = mapRowToImages(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return images;
    }

    @Override
    public Images createImages(Images images) {
        return null;
    }

    @Override
    public Images updateImages(Images images) {
        return null;
    }

    private Images mapRowToImages(SqlRowSet rowSet){
        Images images = new Images();
        images.setImageId(rowSet.getInt("img_id"));
        images.setPropId(rowSet.getInt("prop_id"));
        images.setImageURL(rowSet.getString("img_url"));

        return images;

    }



}
