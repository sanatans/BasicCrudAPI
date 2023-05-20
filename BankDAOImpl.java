package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.bank.model.Bank;


public class BankDAOImpl implements RowMapper<Bank> {
	
	@Override 
	public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bank bank = new Bank();
		bank.setBankId(rs.getLong("BANKID"));
		bank.setBankName(rs.getString("BANKNAME"));
		bank.setBankShortName(rs.getString("BANKSHORTNAME"));
		bank.setBankFIID(rs.getString("BANKFIID"));
		bank.setContactPersonName(rs.getString("CONTACTPERSONNAME"));
		bank.setMobileNumber(rs.getString("MOBILENUMBER"));
	    bank.setEmailId(rs.getString("EMAILID"));
		bank.setDateFormat(rs.getString("DATEFORMAT"));
		bank.setAddress(rs.getString("ADDRESS"));
		bank.setPhoneNumber(rs.getString("PHONENUMBER"));
		bank.setFaxNumber(rs.getString("FAXNUMBER"));
		bank.setCardScheme(rs.getString("CARDSCHEME"));
		bank.setDccServices(rs.getString("DCCSERVICES"));
		bank.setRetryFlag(rs.getString("RETRYFLAG"));
		bank.setOtpInterval(rs.getString("OTPINTERVAL"));
		bank.setOriginatorIIC(rs.getString("ORIGINATORIIC"));
		bank.setDestinationIIC(rs.getString("DESTINATIONIIC"));
		bank.setActivationStatus(rs.getString("ACTIVATIONSTATUS"));
		return bank;
	}

	
}
