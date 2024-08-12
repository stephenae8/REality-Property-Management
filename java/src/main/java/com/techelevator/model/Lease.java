package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Lease {
    //instance variables
    private int leaseId;
    private int userId;
    private int propId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rent;
    private String leaseStatus;
    private int termLength;

    //default constructor
    public Lease() {}

    //constructor
    public Lease(int userId, int leaseId, int propId, LocalDate startDate, LocalDate endDate, double rent, String leaseStatus, int termLength) {
        this.leaseId = leaseId;
        this.userId = userId;
        this.propId = propId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
        this.leaseStatus = leaseStatus;
        this.termLength = termLength;
    }

    //getters
    public int getLeaseId() {
        return leaseId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPropId(){
        return propId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getRent() {
        return rent;
    }

    public String getLeaseStatus() {
        return leaseStatus;
    }

    public int gettermLength() {
        return termLength;
    }

    //setters

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPropId(int propId){
        this.propId = propId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public void setTermLength(int termLength) {
        this.termLength = termLength;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseId=" + leaseId +
                ", userId=" + userId +
                ", propId=" + propId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rent=" + rent +
                ", leaseStatus='" + leaseStatus + '\'' +
                ", termLength=" + termLength +
                '}';
    }
}
