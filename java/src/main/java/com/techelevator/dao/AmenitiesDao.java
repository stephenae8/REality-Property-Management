package com.techelevator.dao;

import com.techelevator.model.Amenities;

import java.util.List;
import java.util.Properties;

public interface AmenitiesDao {
    List<Amenities> getAmenitiesByPropId(Properties incomingProperty);  // get amenities by propId

    Amenities createAmenitiesByPropId(Properties incomingProperty); //create amenities listed by the propId

    Amenities updateAmenitiesByPropId(Properties incomingProperty); //update the amenities by prop Id
}
