package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

//@PreAuthorize("isAuthenticated()")
//RestController
//public class PropertyController {




//    @RequestMapping(path = "/property", method = RequestMethod.GET)
//    public Property property(Principal principal){
//        try {
//           //Property property =  propertyDao.
//        } catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(")
//        }
//    }
//}
