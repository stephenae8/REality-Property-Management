package com.techelevator.dao;

import com.techelevator.model.Payments;
import com.techelevator.model.User;

import java.rmi.dgc.Lease;
import java.util.List;
import java.util.Properties;

public interface PaymentsDao {
    List<Payments> getPaymentsByUserId(User incomingUser); //get payments by user Id

    List<Payments> getPaymentsByPropId(Properties incomingProperty); //get payments by property

    List<Payments> getPaymentsByLeaseId(Lease incomingLease); //get payments by lease Id

    List<Payments> getALlPayments ();

    Payments createPayment (Payments incomingPayment); //create payment by user Id


}
