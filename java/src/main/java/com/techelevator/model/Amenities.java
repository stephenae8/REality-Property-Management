package com.techelevator.model;

public class Amenities {

    private int amenitiesId;
    private int propId;
    private boolean dishwasher;
    private boolean centralAir;
    private boolean laundry;
    private boolean petsAllowed;

    public Amenities () { }

    public Amenities(int amenitiesId, int propId, boolean dishwasher, boolean centralAir, boolean laundry, boolean petsAllowed) {
        this.amenitiesId = amenitiesId;
        this.propId = propId;
        this.dishwasher = dishwasher;
        this.centralAir = centralAir;
        this.laundry = laundry;
        this.petsAllowed = petsAllowed;
    }

    public int getAmenitiesId() {
        return amenitiesId;
    }

    public void setAmenitiesId(int amenitiesId) {
        this.amenitiesId = amenitiesId;
    }

    public int getPropId() {
        return propId;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public boolean isCentralAir() {
        return centralAir;
    }

    public void setCentralAir(boolean centralAir) {
        this.centralAir = centralAir;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }
}
