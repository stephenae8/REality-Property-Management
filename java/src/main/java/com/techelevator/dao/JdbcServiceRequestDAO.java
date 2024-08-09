package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ServiceRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcServiceRequestDAO {

    //instance variables
    private JdbcTemplate jdbcTemplate;


    //constructor
    public JdbcServiceRequestDAO (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    //GET Methods
    public List<ServiceRequest> getListOfServiceReqs(){
        List<ServiceRequest> getListOfServiceReqs = new ArrayList<>();
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getListOfServiceReqs;
    }

    public ServiceRequest getServcieReqById(int reqId){
        //create new variable
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return null; //return new variable
    }

    public ServiceRequest getServcieReqByUserId(int userId){
        //create new variable
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return null; //return new variable
    }

    ServiceRequest getServcieReqByPropId(int propId) {
        //create new variable
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return null; //return new variable
    }


    //POST Methods
    ServiceRequest createServiceRequest (ServiceRequest serviceRequest){
        //create new variable
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
            return null; //return new variable
    }


    //PUT Methods
    ServiceRequest updateServiceRequest(ServiceRequest serviceRequest){
        //create new variable
        String sql = "";

        try {

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
                return null; //return new variable
    }


}
