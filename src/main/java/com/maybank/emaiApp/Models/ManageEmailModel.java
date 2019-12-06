package com.maybank.emaiApp.Models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name = "tbl_manage_email_tm")
	public class ManageEmailModel {
		
		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
		)
		@Column(name = "emailId", updatable = false, nullable = false)
	
		private UUID emailId;
		private String senderEmail;
		private String subjectEmail;
		private String contentEmail;
		private Date registerDate;
				
		
		public UUID getEmailId() {
			return emailId;
		}
		public void setEmailId(UUID emailId) {
			this.emailId = emailId;
		}
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
		public Date getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(Date registerDate) {
			this.registerDate = registerDate;
		}
		
}
