package com.techelevator.controller;

import com.techelevator.dao.LeaseDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Lease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@PreAuthorize("isAuthenticated()")                                          //need authentication for the mgr & owner
@RestController
@CrossOrigin
public class LeaseController {

    //Instance variables
    @Autowired
    private final LeaseDAO leaseDAO;

    //Controller
    public LeaseController(LeaseDAO leaseDAO){
        this.leaseDAO = leaseDAO;
    }

    // GET Methods

//    @GetMapping(path = "lease/{leaseId}")
//    public List<Lease> getListOfLeases();

    //@PreAuthorize("permitAll()")
    @GetMapping(path = "lease/{leaseId}")
    public Lease getLeaseByLeaseId(int leaseId){
        Lease leaseByLeaseId;
        try {
            leaseByLeaseId = leaseDAO.getLeaseByLeaseId(leaseId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease Not Found :(");
        }
        return leaseByLeaseId;
    }

    @PreAuthorize("permitAll()")
    @GetMapping(path = "lease/{userId}")
    public Lease getLeaseByUserId (@PathVariable int userId){
        Lease leaseByUserId;
        try {
            leaseByUserId = leaseDAO.getLeaseByUserId(userId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease Not Found :(");
        }
        return leaseByUserId;
    }



    // POST Methods

    // PUT Methods


}
