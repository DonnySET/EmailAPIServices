package com.maybank.emaiApp.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.emaiApp.DAO.ManageEmailUserDAO;
import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.ManageEmailUserDomain;
import com.maybank.emaiApp.Models.ManageEmailModel;
import com.maybank.emaiApp.Services.IManageEmailServices;

@Service
public class ManageEmailUserImpl implements IManageEmailServices{
	@Autowired
	ManageEmailUserDAO emailDao;
	@Override
	public BaseClassDomain getAllUserBySenderEmail(ManageEmailUserDomain requestData) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		List<ManageEmailModel> listOfUser = this.emailDao.getAllUserBySenderEmail(requestData.getSenderEmail());
		response.setResponseMessage("00", "Sukses", "Sukses");
		response.setListOfEmail(listOfUser);
		return response;
	}
	@Override
	public ManageEmailUserDomain registerEmailWithContent(ManageEmailUserDomain domain) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		
		try {
			
				String result = this.emailDao.registerEmailWithContent(domain.getSenderEmail(), domain.getSubjectEmail(), domain.getContentEmail());
				if (result.equals("db01")) {
					response.setResponseMessage("001", "Sender Email kosong", "Sender Email Empty");
				}else if (result.equals("db02")) {
					response.setResponseMessage("002", "Subject Email kosong", "Subject Email Empty");
				}else if (result.equals("db03")) {
					response.setResponseMessage("002", "Konten Email kosong", "Content Email Empty");
				}
				
				response.setResponseMessage("00", "Sukses", "Sukses");			
			
		}catch(Exception e) {
			response.setResponseMessage("99", "system tidak tersedia", "system unavailable");
		}
		
		
		return response;
	
	}
	
	@Override
	public BaseClassDomain getAllData(ManageEmailUserDomain requestData) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		List<ManageEmailModel> listOfUser = this.emailDao.getAllData();
		response.setResponseMessage("00", "Sukses", "Sukses");
		response.setListOfEmail(listOfUser);
		
		return response;	
		}
	
	@Override
	public BaseClassDomain deleteByEmailId(ManageEmailUserDomain domain) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		
		try {
				String result = this.emailDao.deleteByEmailId(domain.getEmailId().toString());
				if (result.equals("00")) {
					response.setResponseMessage("00", "Sukses", "Succeed");
				}else if (result.equals("404")){
					response.setResponseMessage("404", "Username Tidak Ditemukan", "Username not found");
				}else {
					response.setResponseMessage("99", "Unknown Error", "Unknown Error");
				}
			
		}catch(Exception e){
			response.setResponseMessage("99", "System Tidak Tersedia", "System Unavailable");
		}
		
		return response;
	}
	@Override
	public ManageEmailUserDomain updateByEmailId(ManageEmailUserDomain domain) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		try {
			String result = this.emailDao.updateByEmailId(domain.getEmailId(), domain.getSenderEmail(),domain.getSubjectEmail(), domain.getContentEmail());
			if (result.equals("db02")) {
				response.setResponseMessage("001", "Username kosong", "Username Empty");
			}else if (result.equals("db01")) {
				response.setResponseMessage("002", "email kosong", "email Empty");
			}
			
			response.setResponseMessage("00", "Sukses", "Sukses");
		}catch (Exception e) {
			response.setResponseMessage("99", "System Tidak Tersedia", "System Unavailable");
		}
		return response;
	}
	/*@Override
	public BaseClassDomain getDataByEmailId(ManageEmailUserDomain domain) {
		// TODO Auto-generated method stub
		ManageEmailUserDomain response = new ManageEmailUserDomain();
		ManageEmailModel result = this.emailDao.getDataByEmailId(domain.getEmailId());
		response.setResponseMessage("00", "Sukses", "Sukses");
		response.getSenderEmail();
		return response;
	}*/
	

}
