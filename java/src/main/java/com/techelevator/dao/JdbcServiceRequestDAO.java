package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcServiceRequestDAO implements ServiceRequestDAO {

    //instance variables
//    @Autowired
//    private ServiceRequest serviceRequest;
    private JdbcTemplate jdbcTemplate;

    //constructor
    public JdbcServiceRequestDAO (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //GET Methods
    //POV: the prop mgr/owner can retrieve all service requests
    @Override
    public List<ServiceRequest> getListOfServiceReqs(){
        List<ServiceRequest> getListOfServiceReqs = new ArrayList<>();
        String sql = "SELECT * FROM service_request";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()){
                getListOfServiceReqs.add(mapRowToServiceRequest(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Services Request not found.", e);
        }
        return getListOfServiceReqs;
    }

    @Override
    public ServiceRequest getServcieReqById(int reqId){
        ServiceRequest getServcieReqById = null;
        String sql =
                "SELECT req_id, user_id, prop_id, req_status, req_date, last_updated, req_body, issue_type\n" +
                "FROM service_request\n" +
                "WHERE req_id = ?";

        try {

            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, reqId);
            if (rowSet.next()) {
                getServcieReqById = mapRowToServiceRequest(rowSet);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Service Request not found.", e);
        }
        return getServcieReqById;
    }

    @Override
    public List<ServiceRequest> getServcieReqsByUserId(int userId){
        List<ServiceRequest> getServcieReqsByUserId = new ArrayList<>();
        String sql =
                "SELECT req_id, user_id, prop_id, req_status, req_date, last_updated, req_body, issue_type\n" +
                        "FROM service_request\n" +
                        "WHERE user_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

            while (rowSet.next()) {
                getServcieReqsByUserId.add(mapRowToServiceRequest(rowSet));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Service Requests not found.", e);
        }
        return getServcieReqsByUserId;
    }

    @Override
    public List<ServiceRequest> getServcieReqsByPropId(int propId) {
        List<ServiceRequest> getServcieReqsByPropId = new ArrayList<>();
        String sql =
                "SELECT req_id, user_id, prop_id, req_status, req_date, last_updated, req_body, issue_type\n" +
                        "FROM service_request\n" +
                        "WHERE prop_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, propId);

            while (rowSet.next()) {
                getServcieReqsByPropId.add(mapRowToServiceRequest(rowSet));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Service Requests not found.", e);
        }
        return getServcieReqsByPropId;
    }


    //POST Methods
    @Override
    public ServiceRequest createServiceRequest (ServiceRequest serviceRequest){
        ServiceRequest newServiceRequest = null;
        String sql = "INSERT INTO service_request (user_id, prop_id, req_status, req_date, last_updated, req_body, issue_type)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)\n" +
                "RETURNING req_id";

        try {
            int newServiceRequestId = jdbcTemplate.queryForObject(sql, int.class,
                    serviceRequest.getUserId(),
                    serviceRequest.getPropId(),
                    serviceRequest.getReqStatus(),
                    serviceRequest.getReqDate(),
                    serviceRequest.getLastUpdated(),
                    serviceRequest.getReqDetails(),
                    serviceRequest.getIssueType());

            newServiceRequest = getServcieReqById(newServiceRequestId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
            return newServiceRequest;
    }


    //PUT Methods
    @Override
    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest){
        ServiceRequest updatedServiceRequest = null;
        String sql = "UPDATE service_request\n" +
                "SET req_status = ?, last_updated = ?\n" +
                "WHERE req_id = ?\n" +
                ";";

        try {
            int numRows = jdbcTemplate.update(sql, serviceRequest.getReqStatus(), serviceRequest.getLastUpdated(),serviceRequest.getReqId());

            if (numRows == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedServiceRequest = getServcieReqById(serviceRequest.getReqId());
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
                return updatedServiceRequest;
    }

    @Override
    public List<ServiceRequest> listForOwner(int id) {

        List<ServiceRequest> listOfNew = new ArrayList<>();
        String sql = "SELECT s.req_status, s.prop_id, s.issue_type,s.last_updated FROM service_request as s\n" +
                "JOIN properties as p ON s.prop_id = p.prop_id\n" +
                "WHERE p.owner_id = ?\n" +
                "ORDER BY s.last_updated DESC ;";
        SqlRowSet resulted = jdbcTemplate.queryForRowSet(sql,id);
        if(!resulted.wasNull()){
            while(resulted.next()){
                ServiceRequest newOne = mapRow(resulted);
                listOfNew.add(newOne);
            }
        }
        return listOfNew;
    }


    //MapRowSet
    private ServiceRequest mapRowToServiceRequest(SqlRowSet rowSet){
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setReqId(rowSet.getInt("req_id"));
        serviceRequest.setUserId(rowSet.getInt("user_id"));
        serviceRequest.setPropId(rowSet.getInt("prop_id"));
        serviceRequest.setReqStatus(rowSet.getString("req_status"));
        serviceRequest.setReqDate(rowSet.getTimestamp("req_date").toLocalDateTime());
        if (rowSet.getTimestamp("last_updated") != null) {
            serviceRequest.setLastUpdated(rowSet.getTimestamp("last_updated").toLocalDateTime());
        }
        serviceRequest.setReqDetails(rowSet.getString("req_body"));
        serviceRequest.setIssueType(rowSet.getString("issue_type"));
        return serviceRequest;
    }

    public ServiceRequest mapRow(SqlRowSet sqlStuff){
        ServiceRequest newService = new ServiceRequest();
        newService.setPropId(sqlStuff.getInt("prop_id"));
        newService.setReqStatus(sqlStuff.getString("req_status"));
        newService.setIssueType(sqlStuff.getString("issue_type"));
        newService.setLastUpdated(sqlStuff.getTimestamp("last_updated").toLocalDateTime());
        return newService;
    }


}
