package com.maybank.emaiApp.DAO;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maybank.emaiApp.Models.ManageEmailModel;
import com.maybank.emaiApp.Repository.IManageEmailRepository;

@Component
public class ManageEmailUserDAO {

	@Autowired
	IManageEmailRepository repository;
	
	public List<ManageEmailModel> getAllData(){
		List<ManageEmailModel> result = this.repository.findAll();
		
		return result;
	}
	
	public List<ManageEmailModel> getAllUserBySenderEmail(String senderEmail) {
		
		List<ManageEmailModel> result = this.repository.findBySenderEmail(senderEmail);
		
		return result;
		
	}
	
	
	public String registerEmailWithContent(String senderEmail, String subjectEmail, String contentEmail) throws Exception{
		String responseCode = "99";
		if (senderEmail.length() <= 0) {
			responseCode = "db001";
		}else if(subjectEmail.length() <= 0) {
			responseCode = "db002";
		}else if(contentEmail.length() <= 0){
			responseCode = "db003";
		}else {
			ManageEmailModel model = new ManageEmailModel();
			model.setSenderEmail(senderEmail);
			model.setSubjectEmail(subjectEmail);
			model.setContentEmail(contentEmail);
			model.setRegisterDate(new Date());
			
			
			this.repository.save(model);
			responseCode = "db00";
		}
		
		return responseCode;


	}
	
	public String deleteByEmailId(String emailId) throws Exception{
		String responseCode = "99";
		UUID idEmail = UUID.fromString(emailId);
		ManageEmailModel result = this.repository.findByEmailId(idEmail);
		if (result != null) {
			this.repository.deleteById(idEmail);
			responseCode = "00";
		}else {
			responseCode = "404"; //data not found
		}
		
		return responseCode;
	}
	
	public String updateByEmailId(UUID emailId, String senderEmail, String subjectEmail, String contentEmail) {
		String responseCode = "99";
		if(senderEmail.length() <= 0) {
			responseCode = "d01";
		}else {
			ManageEmailModel result = repository.findByEmailId(emailId);
			result.setEmailId(emailId);
			result.setSenderEmail(senderEmail);
			result.setSubjectEmail(subjectEmail);
			result.setContentEmail(contentEmail);
			
			this.repository.save(result);
		}
		
		return responseCode;
	}

	public ManageEmailModel getDataByEmailId(UUID emailId) {
		// TODO Auto-generated method stub
		ManageEmailModel result = repository.findByEmailId(emailId);

		
		return result;
	}
	
}
