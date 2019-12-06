package com.maybank.emaiApp.Services;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.RegisterEmailUserDomain;

public interface IUserEmailManagementServices {
	RegisterEmailUserDomain registerEmailUser(RegisterEmailUserDomain domain);
	RegisterEmailUserDomain deleteEmailByUser(RegisterEmailUserDomain domain);
	BaseClassDomain deleteEmailByUserId(RegisterEmailUserDomain requestData);
	BaseClassDomain getAllUserByEmail(RegisterEmailUserDomain requestData);
	BaseClassDomain updateEmailByUserName(RegisterEmailUserDomain requestData);
	
}
