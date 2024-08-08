package com.techelevator.controller;

import com.techelevator.dao.MessagesDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Messages;
import com.techelevator.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin

public class MessagesController {

    @Autowired
    private MessagesDao messagesDao;

    public MessagesController (MessagesDao messagesDao) {
        this.messagesDao = messagesDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping (path = "/messages/user/{userId}", method = RequestMethod.GET)
    public List<Messages> getMessagesByUserId(@PathVariable int userId){
        List<Messages> messagesByUserIdList = messagesDao.getMessagesByUserId(userId);

        if(messagesByUserIdList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Messages Not Found. ");
        }
        return messagesByUserIdList;
    }

    @RequestMapping(path = "/messages/message/{msgId}", method = RequestMethod.GET)
    public Messages getMessagesByMsgId (@PathVariable int msgId) {
        Messages messages = messagesDao.getMessagesByMsgId(msgId);

        if (messages == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found.");
        } else {
            return messages;
        }
    }

    @ResponseStatus(HttpStatus.CREATED) // return a 201 status code if successful
    @RequestMapping(path = "/messages/create", method = RequestMethod.POST)

    public Messages postMapping(@RequestBody Messages incomingData) {
        //save the application in confirmedApplication
        try {
            return messagesDao.createMessage(incomingData);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found.");
        }
    }






}
