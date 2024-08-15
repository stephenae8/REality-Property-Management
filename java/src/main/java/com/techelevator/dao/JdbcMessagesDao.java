package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Messages;
import com.techelevator.model.Payments;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMessagesDao implements MessagesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMessagesDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Messages> getMessagesByUserId(int userId) {
        List<Messages> messages = new ArrayList<>();
        String sql = "SELECT \n" +
                "    m.msg_id,\n" +
                "    m.contact_type,\n" +
                "    m.user_to,\n" +
                "    CONCAT(u_to.fName, ' ', u_to.lName) AS to_full_name,\n" +
                "    m.user_from,\n" +
                "    CONCAT(u_from.fName, ' ', u_from.lName) AS from_full_name,\n" +
                "    m.subject,\n" +
                "    m.msg_body,\n" +
                "    m.msg_date\n" +
                "FROM \n" +
                "    messages m\n" +
                "JOIN \n" +
                "    users u_to ON m.user_to = u_to.user_id\n" +
                "JOIN \n" +
                "    users u_from ON m.user_from = u_from.user_id\n" +
                "WHERE \n" +
                "    m.user_to = ?  OR m.user_from = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
            while (results.next()) {
                messages.add(mapRowToMessages(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return messages;
    }

    @Override
    public Messages createMessage(Messages messages) {
        Messages newMessages = null;

        String sql = "INSERT into messages (contact_type, user_to, user_from, subject, msg_body, msg_date)" +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING msg_id;";
        try {
            int newMessagesId = jdbcTemplate.queryForObject(sql,int.class,messages.getContactType(),
                    messages.getUserTo(), messages.getUserFrom(),
                    messages.getSubject(), messages.getMsgBody(), messages.getMsgDate());

            newMessages = getMessagesByMsgId(newMessagesId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newMessages;
    }

    @Override
    public Messages getMessagesByMsgId(int msgId) {
        Messages messages = null;

        String sql = "SELECT * " +
                "FROM messages " +
                "WHERE msg_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, msgId);
            if (results.next()) {
                messages = mapRowToMessages(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return messages;
    }

    private Messages mapRowToMessages(SqlRowSet rowSet){
        Messages messages = new Messages();
        messages.setMsgId(rowSet.getInt("msg_id"));
        messages.setContactType(rowSet.getString("contact_type"));
        messages.setUserTo(rowSet.getInt("user_to"));
        messages.setUserFrom(rowSet.getInt("user_from"));
        messages.setSubject(rowSet.getString("subject"));
        messages.setMsgBody(rowSet.getString("msg_body"));
        messages.setMsgDate(rowSet.getTimestamp("msg_date").toLocalDateTime());

        return messages;
    }

}
