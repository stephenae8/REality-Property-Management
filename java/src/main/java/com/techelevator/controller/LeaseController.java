package com.techelevator.controller;

import com.techelevator.dao.LeaseDAO;
import com.techelevator.dao.PropertyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")                                          //need authentication for the mgr & owner
@RestController
@CrossOrigin
public class LeaseController {

    //Instance variables
    @Autowired
    private final LeaseDAO leaseDAO;


// auth  for the tenant/mgr



}
