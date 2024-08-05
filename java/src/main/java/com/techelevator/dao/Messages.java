package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface Messages {
    List<Messages> getMessagesByUserId(User incomingUser); //get messages by user Id

    Messages createMessage(Messages incomingMessage); //create message by message obj
}
