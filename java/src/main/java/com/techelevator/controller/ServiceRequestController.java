package com.techelevator.controller;


import com.techelevator.dao.JdbcServiceRequestDAO;
import com.techelevator.dao.LeaseDAO;
import com.techelevator.dao.ServiceRequestDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ServiceRequestController {

    //instance variables
    @Autowired
    private ServiceRequestDAO serviceRequestDAO;
    private JdbcTemplate jdbcTemplate;

    //constructor
    public ServiceRequestController(ServiceRequestDAO serviceRequestDAO){
        this.serviceRequestDAO = serviceRequestDAO;
    }

    //Get Methods
    @GetMapping(path = "service-request")
    public List<ServiceRequest> getListOfServiceReqs() {
        List<ServiceRequest> ListOfServiceReqs;
        try {
            ListOfServiceReqs = serviceRequestDAO.getListOfServiceReqs();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Requests Not Found.");
        }

        return ListOfServiceReqs;
    }
    @PreAuthorize("permitAll()")
    @GetMapping(path = "service-request/req/{reqId}")
    public ServiceRequest getServcieReqById(@PathVariable int reqId){
        ServiceRequest ServcieReqById;
        try {
            ServcieReqById = serviceRequestDAO.getServcieReqById(reqId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request Not Found.");
        }
        return ServcieReqById;
    }
    @PreAuthorize("permitAll()")
    @GetMapping(path = "service-request/user/{userId}")
    public List<ServiceRequest> getServcieReqsByUserId(@PathVariable int userId){
        List<ServiceRequest> ServcieReqsByUserId;
        try {
            ServcieReqsByUserId = serviceRequestDAO.getServcieReqsByUserId(userId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Requests Not Found.");
        }
        return ServcieReqsByUserId;
    }
    @PreAuthorize("permitAll()")
    @GetMapping(path = "service-request/prop/{propId}")
    public List<ServiceRequest> getServcieReqByPropId(@PathVariable int propId){
        List<ServiceRequest> ServcieReqsByPropId;
        try {
            ServcieReqsByPropId = serviceRequestDAO.getServcieReqsByPropId(propId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Requests Not Found.");
        }
        return ServcieReqsByPropId;
    }


    //POST
    @PreAuthorize("permitAll()")
    @PostMapping(path = "service-request/create")
    public ServiceRequest createServiceRequest (@Valid @RequestBody ServiceRequest serviceRequest){
        ServiceRequest createServiceRequest;
        try{
            createServiceRequest = serviceRequestDAO.createServiceRequest(serviceRequest);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request Not Created.");
        }
        return createServiceRequest;
    }


    //PUT
    @PreAuthorize("permitAll()")
    @PutMapping(path = "service-request/update")
    public ServiceRequest updateServiceRequest(@Valid @RequestBody ServiceRequest serviceRequest){
        ServiceRequest updateServiceRequest;
        try{
            updateServiceRequest = serviceRequestDAO.updateServiceRequest(serviceRequest);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request Not Updated. ");
        }
        return updateServiceRequest;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "service/owner-update/{userId}")
    public List<ServiceRequest> allService(@PathVariable int userId){
        return serviceRequestDAO.listForOwner(userId);
    }


}
