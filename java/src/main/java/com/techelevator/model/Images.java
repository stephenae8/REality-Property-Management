package com.techelevator.model;

public class Images {
    //instance variables
    private int imageId;
    private int propId;
    private String imageURL;

    public Images () { }


    //constructor
    public Images(int imageId, int propId, String imageURL) {
        this.imageId = imageId;
        this.propId = propId;
        this.imageURL = imageURL;
    }

    //getters
    public int getImageId() {
        return imageId;
    }


    public String getImageURL() {
        return imageURL;
    }

    public int getPropId() {
        return propId;
    }

    //setters
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }
}
