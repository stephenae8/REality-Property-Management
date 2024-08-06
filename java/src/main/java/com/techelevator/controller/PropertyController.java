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

    public PropertyController(PropertyDAO propertyDAO){
        this.propertyDAO = propertyDAO;
    }

//    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("PermitAll()")
    @GetMapping(path = "/property")
    public List<Property> getAllProperties(Principal principal){
        List <Property> propertyList;

        try {
           propertyList =  propertyDAO.getProperties();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return propertyList;
    }

     


}
