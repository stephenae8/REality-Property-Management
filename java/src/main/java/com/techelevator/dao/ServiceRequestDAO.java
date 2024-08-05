package com.techelevator.dao;

import com.techelevator.model.Lease;
import com.techelevator.model.Property;
import com.techelevator.model.ServiceRequest;

import java.util.List;

public interface ServiceRequestDAO {

    List<ServiceRequest> getServiceRequest();
    ServiceRequest getServcieReqById(int reqId);
    ServiceRequest getServcieReqByUserId(int userId);
    ServiceRequest getServcieReqByPropId(int propId);


}
