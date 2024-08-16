package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Applications;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationsDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Applications getApplicationsByUserId(int userId) {

        Applications applications = null;

        String sql = "SELECT \n" +
                "    a.*,\n" +
                "    CONCAT(u.fName, ' ', u.lName) AS applicant_full_name,\n" +
                "    CONCAT(p.address, ', ', p.city, ', ', p.state) AS property_full_address,\n" +
                "    CONCAT(o.fName, ' ', o.lName) AS owner_full_name\n" +
                " FROM \n" +
                "    applications a\n" +
                " JOIN \n" +
                "    users u ON a.user_id = u.user_id\n" +
                " JOIN \n" +
                "    properties p ON a.prop_id = p.prop_id\n" +
                " JOIN \n" +
                "    users o ON p.owner_id = o.user_id" +
                " WHERE u.user_id= ?;";
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

        String sql = "SELECT \n" +
                "    a.*,\n" +
                "    CONCAT(u.fName, ' ', u.lName) AS applicant_full_name,\n" +
                "    CONCAT(p.address, ', ', p.city, ', ', p.state) AS property_full_address,\n" +
                "    CONCAT(o.fName, ' ', o.lName) AS owner_full_name\n" +
                " FROM \n" +
                "    applications a\n" +
                " JOIN \n" +
                "    users u ON a.user_id = u.user_id\n" +
                " JOIN \n" +
                "    properties p ON a.prop_id = p.prop_id\n" +
                " JOIN \n" +
                "    users o ON p.owner_id = o.user_id" +
                " WHERE prop_id= ?;";
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

        String sql = "SELECT \n" +
                "    a.*,\n" +
                "    CONCAT(u.fName, ' ', u.lName) AS applicant_full_name,\n" +
                "    CONCAT(p.address, ', ', p.city, ', ', p.state) AS property_full_address,\n" +
                "    CONCAT(o.fName, ' ', o.lName) AS owner_full_name\n" +
                " FROM \n" +
                "    applications a\n" +
                " JOIN \n" +
                "    users u ON a.user_id = u.user_id\n" +
                " JOIN \n" +
                "    properties p ON a.prop_id = p.prop_id\n" +
                " JOIN \n" +
                "    users o ON p.owner_id = o.user_id;";
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

            newApplications = getApplicationsByAppId(newApplicationId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newApplications;
    }
    @Override
    public Applications getApplicationsByAppId(int appId) {
        Applications applications = null;

        String sql = "SELECT \n" +
                "    a.*,\n" +
                "    CONCAT(u.fName, ' ', u.lName) AS applicant_full_name,\n" +
                "    CONCAT(p.address, ', ', p.city, ', ', p.state) AS property_full_address,\n" +
                "    CONCAT(o.fName, ' ', o.lName) AS owner_full_name\n" +
                " FROM \n" +
                "    applications a\n" +
                " JOIN \n" +
                "    users u ON a.user_id = u.user_id\n" +
                " JOIN \n" +
                "    properties p ON a.prop_id = p.prop_id\n" +
                " JOIN \n" +
                "    users o ON p.owner_id = o.user_id" +
                " WHERE app_id= ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appId);
            if (results.next()) {
                applications = mapRowToApplications(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return applications;
    }

    @Override
    public List<Applications> statusOwnerByID(int id) {

        List<Applications> newAppl = new ArrayList<>();
        String sqlStuff = "SELECT a.prop_id, a.app_status, a.app_date FROM applications as a \n" +
                "JOIN properties as p ON a.prop_id = p.prop_id\n" +
                "WHERE p.owner_id = ? AND app_status ILIKE '%approved%'\n" +
                "ORDER BY app_date DESC;";

        SqlRowSet newSearch = jdbcTemplate.queryForRowSet(sqlStuff, id);
        if(!newSearch.wasNull()){
            while(newSearch.next()){
                Applications newOne = mapRow(newSearch);
                newAppl.add(newOne);
            }
        }
        return newAppl;
    }

    @Override
    public Applications updateApplication(Applications applications) {
        Applications updatedApplications = null;
        String sql = "UPDATE applications SET app_status = ? " + "WHERE app_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, applications.getAppStatus(), applications.getAppId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedApplications = getApplicationsByAppId(applications.getAppId());
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
        if (rowSet.getString("applicant_full_name") != null) {
            applications.setApplicantName(rowSet.getString("applicant_full_name"));
        }
        if (rowSet.getString("property_full_address") != null) {
            applications.setPropertyAddress(rowSet.getString("property_full_address"));
        }
        if (rowSet.getString("owner_full_name") != null) {
            applications.setOwnerName(rowSet.getString("owner_full_name"));
        }

        return applications;

    }

    public Applications mapRow(SqlRowSet sql){
        Applications newOne = new Applications();
        newOne.setAppStatus(sql.getString("app_status"));
        newOne.setAppDate(sql.getTimestamp("app_date").toLocalDateTime());
        newOne.setPropId(sql.getInt("prop_id"));
        return newOne;

    }
}
