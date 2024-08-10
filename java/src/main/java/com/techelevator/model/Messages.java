package com.techelevator.model;

import java.time.LocalDateTime;

public class Messages {

    private int msgId;
    private String contactType;
    private int userTo;
    private String userToFullName;
    private int userFrom;
    private String userFromFullName;
    private String subject;
    private String msgBody;
    private LocalDateTime msgDate;

    public Messages () { }

    public Messages (int msgId, String contactType, int userTo, int userFrom, String subject, String msgBody, LocalDateTime msgDate){
        this.msgId = msgId;
        this.contactType=contactType;
        this.userTo = userTo;
        this.userFrom= userFrom;
        this.subject=subject;
        this.msgBody=msgBody;
        this.msgDate= msgDate;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public int getUserTo() {
        return userTo;
    }

    public void setUserTo(int userTo) {
        this.userTo = userTo;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public LocalDateTime getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(LocalDateTime msgDate) {
        this.msgDate = msgDate;
    }

    public String getUserToFullName() {
        return userToFullName;
    }

    public void setUserToFullName(String userToFullName) {
        this.userToFullName = userToFullName;
    }

    public String getUserFromFullName() {
        return userFromFullName;
    }

    public void setUserFromFullName(String userFromFullName) {
        this.userFromFullName = userFromFullName;
    }
}
