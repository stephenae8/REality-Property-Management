package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.model.Applications;
import com.techelevator.model.User;

import java.util.List;
import java.util.Properties;

public interface ApplicationsDao {

    Applications getApplicationsByUserId(User incomingUser); //get app by user Id

    Applications getApplicationsByPropId(Properties incomingProperty); //get app by prop Id

    List<Applications> getAllApplications(); //get a list of ALL apps

    Applications createApplication(Application incomingApplication); //create app by incoming app

    Applications updateApplication (Application incomingApplication); //update specific app by app
}
