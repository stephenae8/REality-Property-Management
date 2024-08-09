package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Lease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLeaseDAO implements LeaseDAO{


    //instance variables
    private JdbcTemplate jdbcTemplate;

    //constructor

    public JdbcLeaseDAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    //GET Methods

    //POV: the prop mgr/ownr can retrieve all leases
    @Override
    public List<Lease> getListOfLeases(){
        List<Lease> getListOfLeases = new ArrayList<>();
        String sql = "SELECT * FROM leases";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()){
                getListOfLeases.add(mapRowToLease(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Leases not found.", e);
        }

        return getListOfLeases;
    }

    //POV: the prop mgr/owner can filter & retrieve based on the lease ID
    @Override
    public Lease getLeaseByLeaseId(int leaseId){
        Lease getLeaseByLeaseId = null;
        String sql =
                "SELECT lease_id, user_id, prop_id, start_date, end_date, rent, lease_status, term_length\n" +
                "FROM leases\n" +
                "WHERE lease_id = ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, leaseId);
            if (rowSet.next()) {
                getLeaseByLeaseId = mapRowToLease(rowSet);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e){
            throw new DaoException("Lease not found.", e);
        }
        return getLeaseByLeaseId;
    }

    //POV: the prop mgr/owner can filter & retrieve based on the owner ID
    @Override
     public Lease getLeaseByUserId(int userId){
    Lease getLeaseByUserId = null;
    String sql =
            "SELECT lease_id, user_id, prop_id, start_date, end_date, rent, lease_status, term_length\n" +
                    "FROM leases\n" +
                    "WHERE user_id = ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
            if (rowSet.next()) {
                getLeaseByUserId = mapRowToLease(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("Lease not found.", e);
        }
        return getLeaseByUserId;
    }

    //POST Methods
    @Override
    public Lease createLease(Lease lease) {
        String sql =
                "INSERT INTO leases (user_id, prop_id, start_date, end_date, rent, lease_status, term_length)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)\n" +
                "RETURNING lease_id";
        try {
            jdbcTemplate.update(sql,
                    lease.getUserId(),
                    lease.getPropId(),
                    lease.getStartDate(),
                    lease.getEndDate(),
                    lease.getRent(),
                    lease.getLeaseStatus(),
                    lease.gettermLength());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (NullPointerException e) {
            throw new DaoException("Lease cannot be created.", e);
        }
        return lease;
    }

    //PUT Methods
    //POV: prop mgr can update the lease status
    @Override
    public Lease updateLeaseStatus(Lease lease) {
        Lease updatedLease = null;
                String sql =
            "UPDATE leases\n" +
            "SET lease_status = ?\n" +
            "WHERE lease_id = ?\n" +
            ";";

        try {
           int numRows = jdbcTemplate.update(sql, lease.getLeaseStatus());

           if (numRows == 0){
               throw new DaoException("Zero rows affected, expected at least one");
           } else {
               updatedLease = getLeaseByLeaseId(lease.getLeaseId());
           }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedLease;
    }

    //MapRowSet
    private Lease mapRowToLease(SqlRowSet rowSet) {
        Lease lease = new Lease();
        lease.setLeaseId(rowSet.getInt("lease_id"));
        lease.setUserId(rowSet.getInt("user_id"));
        lease.setPropId(rowSet.getInt("prop_id"));
        lease.setStartDate(rowSet.getDate("start_date").toLocalDate());
        lease.setEndDate(rowSet.getDate("end_date").toLocalDate());
        lease.setRent(rowSet.getDouble("rent"));
        lease.setLeaseStatus(rowSet.getString("lease_status"));
        lease.settermLength(rowSet.getInt("term_length"));
        return lease;
    }

}
