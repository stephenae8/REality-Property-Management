package com.techelevator.dao;

import com.techelevator.model.Property;

import java.awt.*;
import java.util.List;

public interface ImagesDAO {

    List<Image> getImages();
    Image getImageById(int imageId);
    Image getImageByPropID(int propId);

}
