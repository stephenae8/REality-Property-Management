package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDAO {

    List<Property> getProperties();
    Property getPropertyById(int propId);

    Property getPropertyByOwnerId(int ownerId);

}
