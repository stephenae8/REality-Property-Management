package com.techelevator.dao;

import com.techelevator.model.Messages;

import java.util.List;

public interface MessagesDao {
    List<Messages> getMessagesByUserId(int userId); //get messages by user Id

    Messages createMessage(Messages messages); //create message by message obj

    Messages getMessagesByMsgId(int msgId);
}
