package com.maybank.emaiApp.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.DemoSelfieDomain;
import com.maybank.emaiApp.Services.IDemoSelfieService;

@RestController
@RequestMapping(value = {"/demoSelfie"})
public class DemoSelfieController {
	@Autowired
	IDemoSelfieService demoService;
	
	@RequestMapping(value= {"/addDemo"},method = RequestMethod.POST)
	public BaseClassDomain addDemo(@RequestBody DemoSelfieDomain requestData,HttpServletResponse servletResponse) {
		BaseClassDomain responseObject;
		
		responseObject = this.demoService.addDemo(requestData);		
		return responseObject;
	}

}
