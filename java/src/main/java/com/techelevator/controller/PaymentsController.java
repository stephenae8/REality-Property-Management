package com.techelevator.controller;

import com.techelevator.dao.ApplicationsDao;
import com.techelevator.dao.PaymentsDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Applications;
import com.techelevator.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@PreAuthorize("isAuthenticate()")
@RestController
@CrossOrigin

public class PaymentsController {

    @Autowired
    private PaymentsDao paymentsDao;

    public PaymentsController (PaymentsDao paymentsDao) {
        this.paymentsDao = paymentsDao;
    }

    @GetMapping (path = "/payments")
    public List<Payments> getAllPayments(){
        List<Payments> paymentsList;

        try{
            paymentsList = paymentsDao.getALlPayments();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found: ");
        }

        return paymentsList;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping (path = "/payments/user/{userId}", method = RequestMethod.GET)
    public List<Payments> getPaymentsByUserId(@PathVariable int userId){
        List<Payments> paymentsByUserId = paymentsDao.getPaymentsByUserId(userId);

        if (paymentsByUserId == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Not Found.");
        }
        return paymentsByUserId;
    }

    @RequestMapping (path = "/payments/property/{propId}", method = RequestMethod.GET)
    public List<Payments> getPaymentsByPropId(@PathVariable int propId){
        List<Payments> paymentsByPropIdList = paymentsDao.getPaymentsByPropId(propId);

        if (paymentsByPropIdList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Not Found.");
        }
        return paymentsByPropIdList;
    }

    @RequestMapping (path = "/payments/lease/{leaseId}", method = RequestMethod.GET)
    public List<Payments> getPaymentsByLeaseId(@PathVariable int leaseId){
        List<Payments> paymentsByLeaseIdList = paymentsDao.getPaymentsByLeaseId(leaseId);

        if(paymentsByLeaseIdList == null) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Not Found :(");
        }
        return paymentsByLeaseIdList;
    }

    @RequestMapping(path = "/payments/payment/{payId}", method = RequestMethod.GET)
    public Payments getPaymentsByPayId (@PathVariable int payId) {
        Payments payments = paymentsDao.getPaymentsByPayId(payId);

        if (payments == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found.");
        } else {
            return payments;
        }
    }

    @ResponseStatus(HttpStatus.CREATED) // return a 201 status code if successful
    @RequestMapping(path = "/payments/create", method = RequestMethod.POST)

    public Payments postMapping(@RequestBody Payments incomingData) {
        //save the application in confirmedApplication
        try {
            return paymentsDao.createPayment(incomingData);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found.");
        }
    }
}
