package com.techelevator.controller;

import com.techelevator.dao.ImagesDAO;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin

public class ImagesController {
    @Autowired
    private ImagesDAO imagesDAO;

    public ImagesController (ImagesDAO imagesDAO) {
        this.imagesDAO = imagesDAO;
    }

    @GetMapping (path = "/images")
    public List<Images> getImages() {
        List<Images> imagesList;

        try {
            imagesList = imagesDAO.getImages();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Images not found.");
        }

        return imagesList;
    }

    @RequestMapping(path = "/images/image/{imageId}", method = RequestMethod.GET)
    public Images getImageByImageId (@PathVariable int imageId) {
        Images images = imagesDAO.getImagesByImageId(imageId);

        if (images == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found.");
        } else {
            return images;
        }
    }

    @RequestMapping(path = "/images/property/{propId}", method = RequestMethod.GET)
    public Images getImageByPropId (@PathVariable int propId) {
        Images images = imagesDAO.getImagesByPropId(propId);

        if (images == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found.");
        } else {
            return images;
        }
    }

    @ResponseStatus(HttpStatus.CREATED) // return a 201 status code if successful
    @RequestMapping(path = "/images/create", method = RequestMethod.POST)

    public Images postMapping(@RequestBody Images incomingData) {
        //save the application in confirmedApplication
        try {
            return imagesDAO.createImages(incomingData);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Images not found.");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/images/update", method = RequestMethod.PUT)

    public Images updateImages(@RequestBody Images updatedImages){

        try{
            return imagesDAO.updateImages(updatedImages);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Images not found.");
        }

    }








}

