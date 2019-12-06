package com.maybank.emaiApp.Services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.emaiApp.DAO.RegisterUserEmailDAO;
import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.RegisterEmailUserDomain;
import com.maybank.emaiApp.Models.EmailMasterDataModel;
import com.maybank.emaiApp.Services.IUserEmailManagementServices;


@Service
public class ManageUserEmailServiceImpl implements IUserEmailManagementServices {

	
	@Autowired
	RegisterUserEmailDAO emailDao;

	@Override
	public RegisterEmailUserDomain registerEmailUser(RegisterEmailUserDomain domain) {
		RegisterEmailUserDomain response = new RegisterEmailUserDomain();
		
		try {
			
			//#hit omni
			//#stopre ke db
			//##mapping reseponse code
				String result = this.emailDao.registerEmailUser(domain.getEmail(), domain.getUserName());
				if (result.equals("db02")) {
					response.setResponseMessage("001", "Username kosong", "Username Empty");
				}else if (result.equals("db01")) {
					response.setResponseMessage("002", "email kosong", "email Empty");
				}
				
				response.setResponseMessage("00", "Sukses", "Sukses");			
			
		}catch(Exception e) {
			response.setResponseMessage("99", "system tidak tersedia", "system unavailable");
		}
		
		
		return response;
	
	}

	@Override
	public RegisterEmailUserDomain deleteEmailByUser(RegisterEmailUserDomain domain) {
		// TODO Auto-generated method stub
		RegisterEmailUserDomain response = new RegisterEmailUserDomain();
		
		try {
			if (domain.getUserName().length() <= 0) {
				response.setResponseMessage("001", "Mohon Input Username", "PLease Fill in username");
			}else {
				String result = this.emailDao.deleteEmaiBylUser(domain.getUserName());
				if (result.equals("00")) {
					response.setResponseMessage("00", "Sukses", "Succeed");
				}else if (result.equals("404")){
					response.setResponseMessage("404", "Username Tidak Ditemukan", "Username not found");
				}else {
					response.setResponseMessage("99", "Unknown Error", "Unknown Error");
				}
			}
			
		}catch(Exception e) {
			response.setResponseMessage("99", "System Tidak Tersedia", "System Unavailable");
		}
		
		return response;
	}
	
	@Override
	public RegisterEmailUserDomain deleteEmailByUserId(RegisterEmailUserDomain domain) {
		// TODO Auto-generated method stub
		RegisterEmailUserDomain response = new RegisterEmailUserDomain();
		
		try {
			if (domain.getEmailId().equals("01")) {
				response.setResponseMessage("001", "Mohon Input Email ID", "PLease Fill in Email ID");
			}else {
				String result = this.emailDao.deleteEmaiBylUserId(domain.getEmailId().toString());
				if (result.equals("00")) {
					response.setResponseMessage("00", "Sukses", "Succeed");
				}else if (result.equals("404")){
					response.setResponseMessage("404", "Username Tidak Ditemukan", "Username not found");
				}else {
					response.setResponseMessage("99", "Unknown Error", "Unknown Error");
				}
			}
			
		}catch(Exception e) {
			response.setResponseMessage("99", "System Tidak Tersedia", "System Unavailable");
		}
		
		return response;
	}

	@Override
	public BaseClassDomain getAllUserByEmail(RegisterEmailUserDomain requestData) {
		// TODO Auto-generated method stub
		RegisterEmailUserDomain response = new RegisterEmailUserDomain();
		List<EmailMasterDataModel> listOfUser = this.emailDao.getEmailByUser(requestData.getUserName());
		response.setListOfUser(listOfUser);
		return response;
	}

	@Override
	public BaseClassDomain updateEmailByUserName(RegisterEmailUserDomain requestData) {
		// TODO Auto-generated method stub
		
		RegisterEmailUserDomain response = new RegisterEmailUserDomain();
		
		try {
				String result = this.emailDao.updateEmailByUserName(requestData.getUserName(),requestData.getEmail());
				if (result.equals("db02")) {
					response.setResponseMessage("001", "Username kosong", "Username Empty");
				}else if (result.equals("db01")) {
					response.setResponseMessage("002", "email kosong", "email Empty");
				}
				
				response.setResponseMessage("00", "Sukses", "Sukses");			
			
		}catch(Exception e) {
			response.setResponseMessage("99", "system tidak tersedia", "system unavailable");
		}
		
		
		return response;
	}
	
	
}
