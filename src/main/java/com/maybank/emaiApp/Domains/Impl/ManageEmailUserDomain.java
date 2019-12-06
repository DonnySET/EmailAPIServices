package com.maybank.emaiApp.Domains.Impl;

import java.util.List;
import java.util.UUID;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Models.ManageEmailModel;


public class ManageEmailUserDomain extends BaseClassDomain{
	private String senderEmail;
	private String subjectEmail;
	private String contentEmail;
	private UUID emailId;


	private List<ManageEmailModel> listOfEmail;
	
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSubjectEmail() {
		return subjectEmail;
	}
	public void setSubjectEmail(String subjectEmail) {
		this.subjectEmail = subjectEmail;
	}
	public String getContentEmail() {
		return contentEmail;
	}
	public void setContentEmail(String contentEmail) {
		this.contentEmail = contentEmail;
	}
	public List<ManageEmailModel> getListOfEmail() {
		return listOfEmail;
	}
	public void setListOfEmail(List<ManageEmailModel> listOfEmail) {
		this.listOfEmail = listOfEmail;
	}
	public UUID getEmailId() {
		return emailId;
	}
	public void setEmailId(UUID emailId) {
		this.emailId = emailId;
	}

}