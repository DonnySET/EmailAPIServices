package com.maybank.emaiApp.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.maybank.emaiApp.Models.ManageEmailModel;


public interface IManageEmailRepository extends CrudRepository<ManageEmailModel, UUID>{

	ManageEmailModel findByEmailId(UUID emailId);
	List<ManageEmailModel> findBySenderEmail(String senderEmail);
	List<ManageEmailModel> findAll();
	//ManageEmailModel findByIdEmail(UUID emailId);
}