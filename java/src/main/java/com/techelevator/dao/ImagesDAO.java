package com.techelevator.dao;

import com.techelevator.model.Images;
import com.techelevator.model.Property;

import java.awt.*;
import java.util.List;

public interface ImagesDAO {

    List<Images> getImages();

    Images getImagesById(int imageId);

    Images getImagesByPropId(int propId);

    Images createImages(Images images);

    Images updateImages(Images images); //by prop id

}
