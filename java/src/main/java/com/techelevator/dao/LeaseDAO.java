package com.techelevator.dao;

import com.techelevator.model.Lease;

import java.util.List;

public interface LeaseDAO {

    //GET
    List<Lease> getListOfLeases();
    Lease getLeaseByLeaseId(int leaseId);
    Lease getLeaseByUserId(int userId);

    //POST
    Lease createLease(Lease lease);

    //PUT
    Lease updateLeaseStatus(Lease lease);



}
