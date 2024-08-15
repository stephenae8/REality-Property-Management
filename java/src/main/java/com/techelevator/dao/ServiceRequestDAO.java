package com.techelevator.dao;

import com.techelevator.model.Lease;
import com.techelevator.model.Property;
import com.techelevator.model.ServiceRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceRequestDAO {

    //GET
    List<ServiceRequest> getListOfServiceReqs();
    ServiceRequest getServcieReqById(int reqId);
    List<ServiceRequest> getServcieReqsByUserId(int userId);
    List<ServiceRequest> getServcieReqsByPropId(int propId);

    //POST
    ServiceRequest createServiceRequest (ServiceRequest serviceRequest);

    //PUT
    ServiceRequest updateServiceRequest(ServiceRequest serviceRequest);

    List<ServiceRequest>listForOwner(int id);


}
