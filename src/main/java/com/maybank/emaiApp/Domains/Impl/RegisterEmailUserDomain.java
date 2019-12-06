package com.maybank.emaiApp.Domains.Impl;

import java.util.List;
import java.util.UUID;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Models.EmailMasterDataModel;

public class RegisterEmailUserDomain extends BaseClassDomain{
	
	private String userName;
	private String email;
	private UUID emailId;
	
	
	private List<EmailMasterDataModel> listOfUser;
	
	public List<EmailMasterDataModel> getListOfUser() {
		return listOfUser;
	}
	public void setListOfUser(List<EmailMasterDataModel> listOfUser) {
		this.listOfUser = listOfUser;
	}
	public UUID getEmailId() {
		return emailId;
	}
	public void setEmailId(UUID emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
