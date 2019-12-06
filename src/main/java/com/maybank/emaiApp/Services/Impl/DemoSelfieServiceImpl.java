package com.maybank.emaiApp.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.emaiApp.DAO.DemoSelfieDAO;
import com.maybank.emaiApp.Domains.Impl.DemoSelfieDomain;
import com.maybank.emaiApp.Services.IDemoSelfieService;

@Service
public class DemoSelfieServiceImpl implements IDemoSelfieService {
	@Autowired
	DemoSelfieDAO demoDao;
	@Override
	public DemoSelfieDomain addDemo(DemoSelfieDomain domain) {
		// TODO Auto-generated method stub
		DemoSelfieDomain response = new DemoSelfieDomain();
		
		try {
			
				String result = this.demoDao.addDemo(domain.getNik(), domain.getNama(), domain.getFoto());
				if (result.equals("db01")) {
					response.setResponseMessage("001", "nik kosong", "Sender Email Empty");
				}else if (result.equals("db02")) {
					response.setResponseMessage("002", "nama kosong", "Subject Email Empty");
				}else if (result.equals("db03")) {
					response.setResponseMessage("002", "foto kosong", "Content Email Empty");
				}
				
				response.setResponseMessage("00", "Sukses", "Sukses");
		}catch(Exception e) {
			response.setResponseMessage("99", "system tidak tersedia", "system unavailable");
		}
		
		
		return response;
	
	}
}
