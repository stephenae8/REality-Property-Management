package com.techelevator.dao;

import com.techelevator.model.Amenities;
import com.techelevator.model.Images;
import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDAO {

    //Get
    List<Property> getProperties();
    Property getPropertyByPropId(int propId);
    List<Property> getPropertiesByOwnerId(int ownerId);

    //Post
    Property createProperty(Property property, Amenities amenities, Images images);

    //Put
    Property updatePropByPropId(Property property, Amenities amenities, Images images);
}
