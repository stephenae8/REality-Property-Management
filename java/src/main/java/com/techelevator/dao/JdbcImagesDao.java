package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Images;
import org.springframework.dao.DataIntegrityViolationException;
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
    public Images getImagesByImageId(int imageId) {
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
        Images newImage = null;

        String sql = "INSERT into images (prop_id, img_url)" +
                "VALUES (?, ?) RETURNING img_id;";
        try {
            int newImageId = jdbcTemplate.queryForObject(sql, int.class, images.getPropId(),
                    images.getImageURL());

            newImage = getImagesByImageId(newImageId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newImage;

    }

    @Override
    public Images updateImages(Images images) {
        Images updatedImages = null;
        String sql = "UPDATE images SET img_url= ?" + "WHERE prop_id = ? AND img_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, images.getImageURL(),
                    images.getPropId(), images.getImageId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedImages = getImagesByImageId(images.getImageId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedImages;
    }

    private Images mapRowToImages(SqlRowSet rowSet){
        Images images = new Images();
        images.setImageId(rowSet.getInt("img_id"));
        images.setPropId(rowSet.getInt("prop_id"));
        images.setImageURL(rowSet.getString("img_url"));

        return images;

    }



}
