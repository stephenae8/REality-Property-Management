package com.techelevator.dao;

import com.techelevator.model.Amenities;

import java.util.List;
import java.util.Properties;

public interface AmenitiesDao {
    List<Amenities> getAmenities();  // get all amenities

    Amenities getAmenitiesByPropId(int propId); //get amenities by Property ID

    Amenities getAmenitiesByAmenitiesId(int amenitiesId);

    Amenities createAmenities(Amenities amenities); //create amenities listed by the propId

    Amenities updateAmenities(Amenities amenities); //update the amenities by prop Id
}
