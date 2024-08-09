package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ServiceRequest {
    //instance variables
    private int reqId;
    private int userId;
    private int propId;
    private String reqStatus;
    private LocalDateTime reqDate;
    private LocalDateTime lastUpdated;
    private String reqDetails;
    private String issueType;


    //default constructor
    public ServiceRequest (){}

    //constructors
    public ServiceRequest(int reqId, int userId, int propId, String reqStatus, LocalDateTime reqDate, LocalDateTime lastUpdated, String reqDetails, String issueType) {
        this.reqId = reqId;
        this.userId = userId;
        this.propId = propId;
        this.reqStatus = reqStatus;
        this.reqDate = reqDate;
        this.lastUpdated = lastUpdated;
        this.reqDetails = reqDetails;
        this.issueType = issueType;
    }

    //getters
    public int getReqId() {
        return reqId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPropId() {
        return propId;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public LocalDateTime getReqDate() {
        return reqDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getReqDetails() {
        return reqDetails;
    }

    public String getIssueType() {
        return issueType;
    }


    //setters
    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public void setReqDate(LocalDateTime reqDate) {
        this.reqDate = reqDate;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setReqDetails(String reqDetails) {
        this.reqDetails = reqDetails;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

}
