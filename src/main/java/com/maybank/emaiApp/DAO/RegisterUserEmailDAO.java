package com.maybank.emaiApp.DAO;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maybank.emaiApp.Models.EmailMasterDataModel;
import com.maybank.emaiApp.Repository.IRegisterEmailRepository;


@Component
public class RegisterUserEmailDAO {
	
	
	@Autowired
	IRegisterEmailRepository repository;
	
	
	public String registerEmailUser(String email, String userName) throws Exception{
		String responseCode = "99";
		if (email.length() <= 0) {
			responseCode = "db001";
		}else if(userName.length() <= 0) {
			responseCode = "db002";
		}else {
			EmailMasterDataModel model = new EmailMasterDataModel();
			model.setEmail(email);
			model.setUserName(userName);
			model.setRegisterDate(new Date());
			
			
			this.repository.save(model);
			responseCode = "db00";
		}
		
		return responseCode;


	}
	
	public List<EmailMasterDataModel> getEmailByUser(String userName) {
		
		List<EmailMasterDataModel> result = this.repository.findByUserName(userName);
		
		return result;
		
	}
	
	public String deleteEmaiBylUser(String userName) throws Exception{
		String responseCode = "99";
		
		List<EmailMasterDataModel> result = this.repository.findByUserName(userName);
		if (result.size() > 0) {
			this.repository.delete(result.get(0));
			responseCode = "00";
		}else {
			responseCode = "404"; //data not found
		}
		
		return responseCode;
	}
	
	public String deleteEmaiBylUserId(String emailId) throws Exception{
		String responseCode = "99";
		UUID idEmail = UUID.fromString(emailId);
		Optional<EmailMasterDataModel> result = this.repository.findByEmailId(idEmail);
		if (result.isPresent()) {
			this.repository.deleteById(idEmail);
			responseCode = "00";
		}else {
			responseCode = "404"; //data not found
		}
		
		return responseCode;
	}
	
	public String updateEmailByUserName(String userName, String email) {
		String responseCode = "99";
		List<EmailMasterDataModel> result = this.repository.findByUserName(userName);
		if(userName.length() < 0) {
			responseCode="db01";
		}else if(email.length() < 0 ){
			responseCode="db02";
		}else {
			EmailMasterDataModel model = new EmailMasterDataModel();
			model.setEmail(email);
			
			this.repository.save(model);
		}
		
		return responseCode;
			
	}
		
	
	
}
