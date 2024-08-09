package com.techelevator.dao;

import com.techelevator.model.Lease;
import com.techelevator.model.Property;
import com.techelevator.model.ServiceRequest;

import java.util.List;

public interface ServiceRequestDAO {

    //GET
    List<ServiceRequest> getListOfServiceReqs();
    ServiceRequest getServcieReqById(int reqId);
    ServiceRequest getServcieReqByUserId(int userId);
    ServiceRequest getServcieReqByPropId(int propId);

    //POST
    ServiceRequest createServiceRequest (ServiceRequest serviceRequest);

    //PUT
    ServiceRequest updateServiceRequest(ServiceRequest serviceRequest);


}
