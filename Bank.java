package com.bank.model;

import org.springframework.stereotype.Component;

@Component
public class Bank {
    public String getBankName() { 
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankShortName() {
		return bankShortName;
	}
	public void setBankShortName(String bankShortName) {
		this.bankShortName = bankShortName;
	}
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long generatedId) {
		this.bankId = generatedId;
	}
	public String getBankFIID() {
		return bankFIID;
	}
	public void setBankFIID(String bankFIID) {
		this.bankFIID = bankFIID;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getCardScheme() {
		return cardScheme;
	}
	public void setCardScheme(String cardScheme) {
		this.cardScheme = cardScheme;
	}
	public String getDccServices() {
		return dccServices;
	}
	public void setDccServices(String dccServices) {
		this.dccServices = dccServices;
	}
	public String getRetryFlag() {
		return retryFlag;
	}
	public void setRetryFlag(String retryFlag) {
		this.retryFlag = retryFlag;
	}
	public String getOtpInterval() {
		return otpInterval;
	}
	public void setOtpInterval(String otpInterval) {
		this.otpInterval = otpInterval;
	}
	public String getOriginatorIIC() {
		return originatorIIC;
	}
	public void setOriginatorIIC(String originatorIIC) {
		this.originatorIIC = originatorIIC;
	}
	public String getDestinationIIC() {
		return destinationIIC;
	}
	public void setDestinationIIC(String destinationIIC) {
		this.destinationIIC = destinationIIC;
	}
	public String getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}
	private String bankName;
    private String bankShortName;
    private Long bankId;
    private String bankFIID;
    private String contactPersonName;
    private String mobileNumber;
    private String emailId;
    private String dateFormat;
    private String address;
    private String phoneNumber;
    private String faxNumber;
    private String cardScheme;
    private String dccServices;
    private String retryFlag;
    private String otpInterval;
    private String originatorIIC;
    private String destinationIIC;
    private String activationStatus;

}
