package com.techelevator.model;

public class Images {
    //instance variables
    private int imageId;
    private int propId;
    private String imageURL;

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


    //setters
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
