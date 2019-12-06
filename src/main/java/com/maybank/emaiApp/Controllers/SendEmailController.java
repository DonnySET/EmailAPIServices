package com.maybank.emaiApp.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.RegisterEmailUserDomain;
import com.maybank.emaiApp.Services.IUserEmailManagementServices;


@RestController
@RequestMapping(value = {"/manageData"})
public class SendEmailController {
		
	@Autowired
	IUserEmailManagementServices serviceManageUser;
	
	@RequestMapping(value= {"/registerEmailUser"},method = RequestMethod.POST)
	public BaseClassDomain registerEmailUser(@RequestBody RegisterEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;

		
		responseObject = this.serviceManageUser.registerEmailUser(requestData);

			
		
		return responseObject;
	}
	
	@RequestMapping(value= {"/deletEmailByUser"},method = RequestMethod.POST)
	public BaseClassDomain deleteEmailByUser(@RequestBody RegisterEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.serviceManageUser.deleteEmailByUser(requestData);
		
		return responseObject;
	}
	
	@RequestMapping(value= {"/deletEmailByUserId"},method = RequestMethod.POST)
	public BaseClassDomain deleteEmailByUserId(@RequestBody RegisterEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.serviceManageUser.deleteEmailByUserId(requestData);
		
		return responseObject;
	}
	
	@RequestMapping(value= {"/getEmailsByUser"},method = RequestMethod.POST)
	public BaseClassDomain getEmailsByUser(@RequestBody RegisterEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.serviceManageUser.getAllUserByEmail(requestData);
		
		return responseObject;
	}
	
	@RequestMapping(value= {"/updateEmailByUserName"}, method = RequestMethod.POST)
	public BaseClassDomain updateEmailByUserName(@RequestBody RegisterEmailUserDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.serviceManageUser.updateEmailByUserName(requestData);
		
		return responseObject;
		
	}
}
