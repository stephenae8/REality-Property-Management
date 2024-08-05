package com.techelevator.model;

public class Property {

    //instance variables
    private int propId;
    private int ownerId;
    private int address;
    private String city;
    private String state;
    private int zipCode;
    private Boolean vacancy;
    private Boolean pending;
    private double rent;
    private int bedrooms;
    private double bathrooms;
    //prob going to need a .to<??> to cut the dec to one placeholder

    //constructor
    public Property(int propId, int ownerId, int address, String city, String state, int zipCode, Boolean vacancy, Boolean pending, double rent, int bedrooms, double bathrooms) {
        this.propId = propId;
        this.ownerId = ownerId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.vacancy = vacancy;
        this.pending = pending;
        this.rent = rent;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }

    //getters
    public int getPropId() {
        return propId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public Boolean getVacancy() {
        return vacancy;
    }

    public Boolean getPending() {
        return pending;
    }

    public double getRent() {
        return rent;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }


    //setters
    public void setPropId(int propId) {
        this.propId = propId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setVacancy(Boolean vacancy) {
        this.vacancy = vacancy;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }
}
