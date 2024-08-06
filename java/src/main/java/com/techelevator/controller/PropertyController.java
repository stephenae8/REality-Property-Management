package com.techelevator.controller;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class PropertyController {

    @Autowired
    private final PropertyDAO propertyDAO;

    public PropertyController(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    //    @ResponseStatus(HttpStatus.OK)
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

    @GetMapping(path = "property/manage-by-owner-id/{owner_id}")            //???????
    public List<Property> getPropByOwnerId(@PathVariable int ownerId) {
        List<Property> propByOwnerIdList;

        try {
            propByOwnerIdList = propertyDAO.getPropertyByOwnerId(ownerId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propByOwnerIdList;

    }

    @GetMapping(path = "property/manage-by-property-id/{prop_id}")
    public Property getPropByPropId(@PathVariable int propId) {
        Property propByPropId;

        try {
            propByPropId = propertyDAO.getPropertyByPropId(propId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propByPropId;

    }



}
