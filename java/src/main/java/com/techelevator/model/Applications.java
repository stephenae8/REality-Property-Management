package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Applications {

    private int appId;
    private int userId;
    private int propId;
    private LocalDate moveInDate;
    private String appStatus;
    private LocalDateTime appDate;


    public Applications () { }

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
}
