package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payments {
    private int payId;
    private int userId;
    private int propId;
    private int leaseId;
    private LocalDate payPeriod;
    private LocalDateTime payDate;
    private double amount;
    private boolean late;

    public Payments () { }

    public Payments (int payId, int userId, int propId, int leaseId, LocalDate payPeriod, LocalDateTime payDate, double amount, boolean late){
        this.payId = payId;
        this.userId = userId;
        this.propId = propId;
        this.leaseId= leaseId;
        this.payPeriod= payPeriod;
        this.payDate= payDate;
        this.amount= amount;
        this.late=late;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
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

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public LocalDate getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(LocalDate payPeriod) {
        this.payPeriod = payPeriod;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }
}
