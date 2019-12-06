package com.maybank.emaiApp.DAO;

import java.io.File;
import java.util.Base64;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.maybank.emaiApp.Models.DemoSelfieModel;
import com.maybank.emaiApp.Repository.IDemoSelfieRepository;

@Component
public class DemoSelfieDAO {

	@Autowired
	IDemoSelfieRepository repository;
	public String addDemo(String nik, String nama, String foto) throws Exception{
		String responseCode = "99";
		if (nik.length() <= 0) {
			responseCode = "db001";
		}else if(nama.length() <= 0) {
			responseCode = "db002";
		}else if(foto.length() <= 0){
			responseCode = "db003";
		}else {
			DemoSelfieModel model = new DemoSelfieModel();
			model.setNik(nik);
			model.setNama(nama);
			model.setFoto("//Users//donnysetiabudi93//Documents//DemoSelfie//"+ nik+"//"+nik+".png");
			 this.repository.save(model);
			//create Folder
			responseCode = "db00";
			 File files = new File("//Users//donnysetiabudi93//Documents//DemoSelfie//"+ nik );
			 if (!files.exists()) {
		            if (files.mkdirs()) {
        	byte[] decodedBytes = Base64.getDecoder().decode(foto);
        	FileUtils.writeByteArrayToFile(new File("//Users//donnysetiabudi93//Documents//DemoSelfie//"+ nik+"//"+nik+".png"), decodedBytes);
		            } 
			 else {
		                System.out.println("Failed to create multiple directories!");
		            }
		        }
		}
		
		return responseCode;


	}
}
