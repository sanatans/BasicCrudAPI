package com.bank.dao;

import java.beans.Statement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.bank.model.Bank;

@Component
public class BankDAO {
	private final String INSERT_BANK = "INSERT INTO BANK VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String DELETE_BANK = "DELETE FROM BANK WHERE BANKID=?";
	private final String GET_BANK = "SELECT BANKNAME,BANKID,BANKSHORTNAME,BANKFIID,CONTACTPERSONNAME,MOBILENUMBER,EMAILID,DATEFORMAT,ADDRESS,PHONENUMBER,FAXNUMBER,CARDSCHEME,DCCSERVICES,RETRYFLAG,OTPINTERVAL,ORIGINATORIIC,DESTINATIONIIC,ACTIVATIONSTATUS FROM BANK WHERE BANKNAME=?";
	private final String GET_BANK_ALL = "SELECT BANKID,BANKNAME,BANKSHORTNAME,BANKFIID,CONTACTPERSONNAME,MOBILENUMBER,EMAILID,DATEFORMAT,ADDRESS,PHONENUMBER,FAXNUMBER,CARDSCHEME,DCCSERVICES,RETRYFLAG,OTPINTERVAL,ORIGINATORIIC,DESTINATIONIIC,ACTIVATIONSTATUS FROM BANK";
	private final String GET_BANK_BY_ID="SELECT BANKNAME,BANKID,BANKSHORTNAME,BANKFIID,CONTACTPERSONNAME,MOBILENUMBER,EMAILID,DATEFORMAT,ADDRESS,PHONENUMBER,FAXNUMBER,CARDSCHEME,DCCSERVICES,RETRYFLAG,OTPINTERVAL,ORIGINATORIIC,DESTINATIONIIC,ACTIVATIONSTATUS  FROM BANK WHERE BANKID=?";

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(Bank bank) {
		int cnt = template.update(INSERT_BANK,bank.getBankId(),bank.getBankName(), bank.getBankShortName(),bank.getBankFIID(),bank.getContactPersonName(),bank.getMobileNumber(),bank.getEmailId(),bank.getDateFormat(),bank.getAddress(),bank.getPhoneNumber(),bank.getFaxNumber(),bank.getCardScheme(),bank.getDccServices(),bank.getRetryFlag(),bank.getOtpInterval(),bank.getOriginatorIIC(),bank.getDestinationIIC(),bank.getActivationStatus());
		return cnt;
	}

	public int remove(Bank bank) {
		int cnt = template.update(DELETE_BANK, bank.getBankId());
		return cnt;
	}

	public Bank get(String bankName) {
		List<Bank> banks = template.query(GET_BANK, new Object[] { bankName }, new BankDAOImpl());
		if (banks.size() == 0)
			return null;
		System.out.println(banks.get(0));
		return banks.get(0);
	}

	public List<Bank> getAll() {
		List<Bank> banks = template.query(GET_BANK_ALL, new BankDAOImpl());
		if (banks.size() == 0)
			return null;
		return banks;
	}
	public Bank getBankById(Long bankId) {
	    
	    try {
	        return template.queryForObject(GET_BANK_BY_ID, new Object[]{bankId}, (rs, rowNum) -> {
	            Bank bank = new Bank();
	            bank.setBankId(rs.getLong("bankId"));
	            bank.setBankName(rs.getString("bankName"));
	            bank.setBankShortName(rs.getString("bankShortName"));
	            bank.setContactPersonName(rs.getString("contactPersonName"));
	            bank.setMobileNumber(rs.getString("mobileNumber"));
	            bank.setBankName(rs.getString("bankName"));
	            bank.setEmailId(rs.getString("emailId"));
	            bank.setDateFormat(rs.getString("dateFormat"));
	            bank.setAddress(rs.getString("address"));
	            bank.setPhoneNumber(rs.getString("phoneNumber"));
	            bank.setFaxNumber(rs.getString("faxNumber"));
	            bank.setCardScheme(rs.getString("cardScheme"));
	            bank.setDccServices(rs.getString("dccServices"));
	            bank.setRetryFlag(rs.getString("retryFlag"));
	            bank.setOtpInterval(rs.getString("otpInterval"));
	            bank.setOriginatorIIC(rs.getString("originatorIIC"));
	            bank.setDestinationIIC(rs.getString("destinationIIC"));
	            bank.setActivationStatus(rs.getString("activationStatus"));
	            // Set other properties as needed
	            return bank;
	        });
	    } catch (EmptyResultDataAccessException e) {
	        return null; // Return null if no bank record is found
	    }
	}
	

	
	public int updateBank(Bank bank) {
	    String query = "UPDATE BANK SET bankName = ?, bankShortName = ?, bankFIID = ?, contactPersonName = ?, " +
	                   "mobileNumber = ?, emailId = ?, dateFormat = ?, address = ?, phoneNumber = ?, faxNumber = ?, " +
	                   "cardScheme = ?, dccServices = ?, retryFlag = ?, otpInterval = ?, originatorIIC = ?, " +
	                   "destinationIIC = ?, activationStatus = ? WHERE bankId = ?";
	    
	    int cnt = template.update(query, bank.getBankName(), bank.getBankShortName(), bank.getBankFIID(),
	                              bank.getContactPersonName(), bank.getMobileNumber(), bank.getEmailId(),
	                              bank.getDateFormat(), bank.getAddress(), bank.getPhoneNumber(), bank.getFaxNumber(),
	                              bank.getCardScheme(), bank.getDccServices(), bank.getRetryFlag(),
	                              bank.getOtpInterval(), bank.getOriginatorIIC(), bank.getDestinationIIC(),
	                              bank.getActivationStatus(), bank.getBankId());
	    return cnt;
	}
	
}
