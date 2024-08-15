package com.techelevator.dao;

import com.techelevator.model.Lease;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface LeaseDAO {

    //GET
    List<Lease> getListOfLeases();
    Lease getLeaseByLeaseId(int leaseId);
    Lease getLeaseByUserId(int userId);

    //potentially: get lease by prop id


    //POST
    Lease createLease(Lease lease);

    //PUT
    Lease updateLeaseStatus(Lease lease);

    BigDecimal getTotal(int id);

    int availableVacancy(int id);

    BigDecimal totalRevenue(int id);

    BigDecimal netProfit(int id);



}
