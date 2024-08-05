package com.techelevator.dao;

import com.techelevator.model.Lease;

import java.util.List;

public interface LeaseDAO {

    List<Lease> getLease();
    Lease getLeaseById(int leaseId);
    Lease getLeaseByUserId(int userId);
    Lease getLeaseByPropId(int propId);
}
