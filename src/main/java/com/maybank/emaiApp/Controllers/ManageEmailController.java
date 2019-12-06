package com.maybank.emaiApp.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.ManageEmailUserDomain;
import com.maybank.emaiApp.Services.IManageEmailServices;

@RestController
@RequestMapping(value = {"/manageEmail"})
public class ManageEmailController {
	
	@Autowired
	IManageEmailServices manageEmailService;
	
	//search email berdasakan Sender Email
	@RequestMapping(value= {"/getEmailBySenderEmail"},method = RequestMethod.POST)
	public BaseClassDomain getAllUserBySenderEmail(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.manageEmailService.getAllUserBySenderEmail(requestData);
		
		return responseObject;
	}
	
	/*//search email berdasakan Email Id
		@RequestMapping(value= {"/getEmailByEmailId"},method = RequestMethod.POST)
		public BaseClassDomain getEmailByEmailId(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
			BaseClassDomain responseObject;
			
			responseObject = this.manageEmailService.getDataByEmailId(requestData);
			
			return responseObject;
		}*/
	
	//Tampilkan Semua Email
	@RequestMapping(value= {"/getAllData"},method = RequestMethod.POST)
	public BaseClassDomain getAllData(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.manageEmailService.getAllData(requestData);
		
		return responseObject;
	}
	
	// insert Email
	@RequestMapping(value= {"/addEmail"},method = RequestMethod.POST)
	public BaseClassDomain registerEmailWithContent(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;

		
		responseObject = this.manageEmailService.registerEmailWithContent(requestData);

		
		
		return responseObject;
	}
	
	//Delete berdasarkan Email id
	@RequestMapping(value= {"/deleteByEmailId"},method = RequestMethod.POST)
	public BaseClassDomain deleteByEmailId(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.manageEmailService.deleteByEmailId(requestData);
		
		return responseObject;
	}
	
	//update berdasarkan email id
	@RequestMapping(value= {"/updateByEmailId"},method = RequestMethod.POST)
	public BaseClassDomain updateByEmailId(@RequestBody ManageEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.manageEmailService.updateByEmailId(requestData);
		
		return responseObject;
	}

}
