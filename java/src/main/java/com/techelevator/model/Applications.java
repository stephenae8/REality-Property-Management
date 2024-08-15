package com.techelevator.model;

import com.techelevator.Application;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Applications {

    private int appId;
    private int userId;
    private int propId;
    private LocalDate moveInDate;
    private String appStatus;
    private LocalDateTime appDate;
    private String applicantName;
    private String propertyAddress;
    private String ownerName;


    public Applications () { }

    public Applications(int appId, int userId, int propId, LocalDate moveInDate, String appStatus, LocalDateTime appDate) {
        this.appId = appId;
        this.userId = userId;
        this.propId = propId;
        this.moveInDate = moveInDate;
        this.appStatus = appStatus;
        this.appDate = appDate;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPropId() {
        return propId;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public LocalDateTime getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDateTime appDate) {
        this.appDate = appDate;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
