package com.techelevator.dao;

import com.techelevator.model.Payments;
import com.techelevator.model.User;

import java.rmi.dgc.Lease;
import java.util.List;
import java.util.Properties;

public interface PaymentsDao {
    List<Payments> getPaymentsByUserId(int userId); //get payments by user Id

    List<Payments> getPaymentsByPropId(int propId); //get payments by property

    List<Payments> getPaymentsByLeaseId(int leaseId); //get payments by lease Id

    List<Payments> getALlPayments ();

    Payments createPayment (Payments payments); //create payment by user Id

    Payments getPaymentsByPayId(int payId);


}
