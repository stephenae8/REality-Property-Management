package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.model.Applications;
import com.techelevator.model.User;

import java.util.List;
import java.util.Properties;

public interface ApplicationsDao {

    Applications getApplicationsByUserId(int userId); //get app by user Id

    Applications getApplicationsByPropId(int propId); //get app by prop Id

    List<Applications> getAllApplications(); //get a list of ALL apps

    Applications createApplication(Applications applications); //create app by incoming app

    Applications updateApplication (Applications applications); //update specific app by app

    Applications getApplicationsByAppId(int appId);

    List<Applications> statusOwnerByID (int id);
}
