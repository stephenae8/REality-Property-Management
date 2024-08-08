package com.techelevator.controller;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")                                          //need authentication for the mgr & owner
@RestController
@CrossOrigin
public class PropertyController {

    //Instance variables
    @Autowired
    private final PropertyDAO propertyDAO;


    //Controller
    public PropertyController(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    //GET methods
    @PreAuthorize("permitAll()")
    @GetMapping(path = "/property")
    public List<Property> getAllProperties() {
        List<Property> propertyList;
        try {
            propertyList = propertyDAO.getProperties();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propertyList;
    }


    @GetMapping(path = "property/retrieve/{owner_id}")
    public List<Property> getPropByOwnerId(@PathVariable int ownerId) {
        List<Property> propByOwnerIdList;

        try {
            propByOwnerIdList = propertyDAO.getPropertiesByOwnerId(ownerId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propByOwnerIdList;

    }


    @GetMapping(path = "property/retrieve/{prop_id}")
    public Property getPropByPropId(@PathVariable int propId) {
        Property propByPropId;
        try {
            propByPropId = propertyDAO.getPropertyByPropId(propId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propByPropId;

    }

    //POST method
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/property/create")
    public Property createProperty (@RequestBody PropertyRequestDto prdto){
        Property createProperty;
        try {
            createProperty = propertyDAO.createProperty(prdto.getProperty(), prdto.getAmenities(),prdto.getImages());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return createProperty;
    }


    //PUT methods
    //prop mgr auth reqd to update prop listings
    //@PreAuthorize();
    // @ResponseStatus(HttpStatus.CREATED)
    //    @PostMapping(path = "/property/create")
    //    public Property createProperty (@RequestBody PropertyRequestDto prdto){
    //        Property createProperty;
    //        try {
    //            createProperty = propertyDAO.createProperty(prdto.getProperty(), prdto.getAmenities(),prdto.getImages());
    //        } catch (DaoException e) {
    //            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
    //        }
    //        return createProperty;
    //    }


}
