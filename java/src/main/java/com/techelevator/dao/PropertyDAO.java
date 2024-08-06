package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDAO {

    List<Property> getProperties();
    Property getPropertyByPropId(int propId);
    List<Property> getPropertyByOwnerId(int ownerId);

}
