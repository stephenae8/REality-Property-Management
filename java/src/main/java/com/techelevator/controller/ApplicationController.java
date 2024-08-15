package com.techelevator.controller;


import com.techelevator.Application;
import com.techelevator.dao.ApplicationsDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Applications;
import com.techelevator.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin

public class ApplicationController {

    @Autowired
    private ApplicationsDao applicationsDao; //instance variable

    public ApplicationController (ApplicationsDao applicationsDao) {
        this.applicationsDao = applicationsDao;
    }

    @GetMapping (path = "/applications")
    public List<Applications> getAllApplications(){
        List<Applications> applicationsList;

        try{
            applicationsList = applicationsDao.getAllApplications();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found.");
        }

        return applicationsList;
    }

    @RequestMapping(path = "/applications/user/{userId}", method = RequestMethod.GET)
    public Applications getApplicationsByUserId (@PathVariable int userId) {
        Applications applications = applicationsDao.getApplicationsByUserId(userId);

        if (applications == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found.");
        } else {
            return applications;
        }
    }
    @ResponseStatus(HttpStatus.CREATED) // return a 201 status code if successful
    @RequestMapping(path = "/applications/create", method = RequestMethod.POST )

    public Applications postMapping(@RequestBody Applications incomingData){
        //save the application in confirmedApplication
        try{
            return applicationsDao.createApplication(incomingData);

        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found.");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/applications/update", method = RequestMethod.PUT)

    public Applications updatedApplication(@Valid @RequestBody Applications updatedApplication){

        try{
            return applicationsDao.updateApplication(updatedApplication);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found.");
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/applications/newfeed/{ownerId}")
    public List<Applications> getApplicationByOwner (@PathVariable int ownerId){
        return applicationsDao.statusOwnerByID(ownerId);
    }

}
