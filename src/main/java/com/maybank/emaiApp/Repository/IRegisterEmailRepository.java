package com.maybank.emaiApp.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.maybank.emaiApp.Models.EmailMasterDataModel;

public interface IRegisterEmailRepository extends CrudRepository<EmailMasterDataModel, UUID> {
	Optional<EmailMasterDataModel> findByEmailId(UUID idEmail);
	List<EmailMasterDataModel> findByUserName(String userName);
	
}
