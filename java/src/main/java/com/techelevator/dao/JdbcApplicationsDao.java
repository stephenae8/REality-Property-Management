package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Applications;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcApplicationsDao implements ApplicationsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationsDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Applications getApplicationsByUserId(int userId) {

        Applications applications = null;

        String sql = "SELECT app_id, user_id, prop_id, move_in_date, app_status, app_date " +
                    "FROM applications " +
                    "WHERE user_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                applications = mapRowToApplications(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return applications;
    }

    @Override
    public Applications getApplicationsByPropId(int propId) {

        Applications applications = null;

        String sql = "SELECT app_id, user_id, prop_id, move_in_date, app_status, app_data " +
                    "FROM applications " +
                    "WHERE prop_id?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propId);
            if (results.next()) {
                applications = mapRowToApplications(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public List<Applications> getAllApplications() {
        List<Applications> applications = new ArrayList<>();

        String sql = "SELECT app_id, user_id, prop_id, move_in_date, app_status, app_date;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                applications.add(mapRowToApplications(results));
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public Applications createApplication(Applications applications) {
        Applications newApplications = null;

        String sql = "INSERT into applications (user_id, prop_id, move_in_date, app_status, app_date)" +
                "VALUES (?, ?, ?, ?, ?) RETURNING app_id;";
        try {
            int newApplicationId = jdbcTemplate.queryForObject(sql, int.class, applications.getUserId(),
                    applications.getPropId(), applications.getMoveInDate(),
                    applications.getAppStatus(), applications.getAppDate());

            newApplications = getApplicationsByUserId(newApplicationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newApplications;
    }

    @Override
    public Applications updateApplication(Applications applications) {
        Applications updatedApplications = null;
        String sql = "UPDATE applications SET app_status = ? " + "WHERE user_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, applications.getMoveInDate(), applications.getAppStatus(),
                    applications.getAppDate());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedApplications = getApplicationsByUserId(applications.getUserId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedApplications;
    }


    private Applications mapRowToApplications(SqlRowSet rowSet){
        Applications applications = new Applications();
        applications.setAppId(rowSet.getInt("app_id"));
        applications.setUserId(rowSet.getInt("user_id"));
        applications.setPropId(rowSet.getInt("prop_id"));
        applications.setMoveInDate(rowSet.getDate("move_in_date").toLocalDate());
        applications.setAppStatus(rowSet.getString("app_status"));
        applications.setAppDate(rowSet.getTimestamp("app_date").toLocalDateTime());

        return applications;

    }
}
