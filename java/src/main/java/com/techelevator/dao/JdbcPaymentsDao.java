package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Amenities;
import com.techelevator.model.Payments;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcPaymentsDao implements PaymentsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPaymentsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Payments> getPaymentsByUserId(int userId) {
        List<Payments> payments = new ArrayList<>();
        String sql = "SELECT pay_id, user_id, prop_id, lease_id, pay_period, pay_date, amount, late " +
                    "FROM payments " +
                    "WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                payments.add(mapRowToPayments(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return payments;
    }

    @Override
    public List<Payments> getPaymentsByPropId(int propId) {
        List<Payments> payments = new ArrayList<>();
        String sql = "SELECT pay_id, user_id, prop_id, lease_id, pay_period, pay_date, amount, late " +
                "FROM payments " +
                "WHERE prop_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propId);
            while (results.next()) {
                payments.add(mapRowToPayments(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return payments;
    }

    @Override
    public List<Payments> getPaymentsByLeaseId(int leaseId) {
        List<Payments> payments = new ArrayList<>();
        String sql = "SELECT pay_id, user_id, prop_id, lease_id, pay_period, pay_date, amount, late " +
                "FROM payments " +
                "WHERE lease_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leaseId);
            while (results.next()) {
                payments.add(mapRowToPayments(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return payments;
    }

    @Override
    public List<Payments> getALlPayments() {
        List<Payments> payments = new ArrayList<>();
        String sql = "SELECT pay_id, user_id, prop_id, lease_id, pay_period, pay_date, amount, late " +
                "FROM payments;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                payments.add(mapRowToPayments(results));
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return payments;
    }

    @Override
    public Payments createPayment(Payments payments) {
        Payments newPayments = null;

        String sql = "INSERT into payments (user_id, prop_id, lease_id, pay_date, amount, late)" +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING pay_id;";
        try {
            int newPaymentsId = jdbcTemplate.queryForObject(sql, int.class, payments.getUserId(),
                    payments.getPropId(), payments.getLeaseId(),
                    payments.getPayDate(), payments.getAmount(), payments.isLate());

            newPayments = getPaymentsByPayId(newPaymentsId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newPayments;
    }

    @Override
    public Payments getPaymentsByPayId(int payId) {
        Payments payments = null;

        String sql = "SELECT pay_id, user_id, prop_id, lease_id, pay_period, pay_date, amount, late " +
                "FROM payments " +
                "WHERE pay_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, payId);
            if (results.next()) {
                payments = mapRowToPayments(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return payments;

    }


    private Payments mapRowToPayments(SqlRowSet rowSet){
        Payments payments = new Payments();
        payments.setPayId(rowSet.getInt("pay_id"));
        payments.setUserId(rowSet.getInt("user_id"));
        payments.setPropId(rowSet.getInt("prop_id"));
        payments.setLeaseId(rowSet.getInt("lease_id"));
        payments.setPayPeriod(rowSet.getDate("pay_period").toLocalDate());
        payments.setPayDate(rowSet.getTimestamp("pay_date").toLocalDateTime());
        payments.setAmount(rowSet.getDouble("amount"));
        payments.setLate(rowSet.getBoolean("late"));

        return payments;
    }


}
