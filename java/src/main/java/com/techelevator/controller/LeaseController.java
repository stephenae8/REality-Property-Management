package com.techelevator.controller;

import com.techelevator.dao.LeaseDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Lease;
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
public class LeaseController {

    //Instance variables
    @Autowired
    private final LeaseDAO leaseDAO;

    //Controller
    public LeaseController(LeaseDAO leaseDAO){
        this.leaseDAO = leaseDAO;
    }

    // GET Methods
    //@PreAuthorize()
    @GetMapping(path = "lease")
    public List<Lease> getListOfLeases(){
        List<Lease> leaseList;
        try {
            leaseList = leaseDAO.getListOfLeases();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property Not Found :(");
        }
        return leaseList;
    }

    @PreAuthorize("permitAll()")
    @GetMapping(path = "lease/{leaseId}")
    public Lease getLeaseByLeaseId(@PathVariable int leaseId){
        Lease leaseByLeaseId;
        try {
            leaseByLeaseId = leaseDAO.getLeaseByLeaseId(leaseId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leases Not Found. ");
        }
        return leaseByLeaseId;
    }

    @PreAuthorize("permitAll()")
    @GetMapping(path = "lease/user/{userId}")
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
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/lease/create")
    public Lease createLease (@Valid @RequestBody Lease lease){
        Lease createLease;
        try{
            createLease = leaseDAO.createLease(lease);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease Not Found :(");
        }
        return createLease;
    }

    // PUT Method
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping (path = "/lease/update")
    public Lease updateLeaseStatus (@Valid @RequestBody Lease lease){
        Lease updateLeaseStatus;
        try{
            updateLeaseStatus = leaseDAO.updateLeaseStatus(lease);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lease Not Updated. ");
        }
        return updateLeaseStatus;
    }


}
