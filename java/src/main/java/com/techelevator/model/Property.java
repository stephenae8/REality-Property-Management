package com.techelevator.model;

public class Property {

    //instance variables
    private int propId;
    private int ownerId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Boolean vacancy;
    private Boolean pending;
    private double rent;
    private int bedrooms;
    private double bathrooms;

    //amenities vars
    private boolean dishwasher;
    private boolean centralAir;
    private boolean laundry;
    private boolean petsAllowed;

    private String[] imgString;


    //default constructor
    public Property() {}

    public Property(int propId, int ownerId, String address, String city, String state, String zipCode, Boolean vacancy, Boolean pending, double rent, int bedrooms, double bathrooms, boolean dishwasher, boolean centralAir, boolean laundry, boolean petsAllowed, String[] imgString) {
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
        this.dishwasher = dishwasher;
        this.centralAir = centralAir;
        this.laundry = laundry;
        this.petsAllowed = petsAllowed;
        this.imgString = imgString;
    }



    //getters
    public int getPropId() {
        return propId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Boolean isVacancy() {
        return vacancy;
    }

    public Boolean isPending() {
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

    public String[] getImgString() {
        return imgString;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public boolean isCentralAir() {
        return centralAir;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }



    //setters
    public void setPropId(int propId) {
        this.propId = propId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
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

    public void setImgString(String[] imgString) {
        this.imgString = imgString;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void setCentralAir(boolean centralAir) {
        this.centralAir = centralAir;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }
}
