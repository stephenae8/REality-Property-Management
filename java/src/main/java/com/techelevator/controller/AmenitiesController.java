package com.techelevator.controller;

import com.techelevator.dao.AmenitiesDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
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

public class AmenitiesController {

    @Autowired
    private AmenitiesDao amenitiesDao;

    public AmenitiesController (AmenitiesDao amenitiesDao) {
        this.amenitiesDao = amenitiesDao;
    }

    @GetMapping (path = "/amenities")
    public List<Amenities> getAmenities(){
        List<Amenities> amenitiesList;

        try{
            amenitiesList = amenitiesDao.getAmenities();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amenities not found.");
        }

        return amenitiesList;
    }

    @RequestMapping(path = "/amenities/property/{propId}", method = RequestMethod.GET)
    public Amenities getAmenitiesByPropId (@PathVariable int propId) {
        Amenities amenities = amenitiesDao.getAmenitiesByPropId(propId);

        if (amenities == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amenity not found.");
        } else {
            return amenities;
        }
    }

    @RequestMapping(path = "/amenities/amenity/{amenitiesId}", method = RequestMethod.GET)
    public Amenities getAmenitiesByAmenitiesId (@PathVariable int amenitiesId) {
        Amenities amenities = amenitiesDao.getAmenitiesByAmenitiesId(amenitiesId);

        if (amenities == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amenity not found.");
        } else {
            return amenities;
        }
    }

    @ResponseStatus(HttpStatus.CREATED) // return a 201 status code if successful
    @RequestMapping(path = "/amenities/create", method = RequestMethod.POST)

    public Amenities postMapping(@RequestBody Amenities incomingData) {
        //save the application in confirmedApplication
        try {
            return amenitiesDao.createAmenities(incomingData);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amenities not found.");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/amenities/update", method = RequestMethod.PUT)

    public Amenities updatedAmenities(@Valid @RequestBody Amenities updatedAmenities){

        try{
            return amenitiesDao.updateAmenities(updatedAmenities);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Amenities not found.");
        }

    }

}
