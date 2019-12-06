package com.maybank.emaiApp.Services;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.ManageEmailUserDomain;

public interface IManageEmailServices {
	BaseClassDomain getAllUserBySenderEmail(ManageEmailUserDomain requestData);
	BaseClassDomain getAllData(ManageEmailUserDomain domain);
	ManageEmailUserDomain registerEmailWithContent(ManageEmailUserDomain domain);
	BaseClassDomain deleteByEmailId(ManageEmailUserDomain domain);
	ManageEmailUserDomain updateByEmailId(ManageEmailUserDomain domain);
	//BaseClassDomain getDataByEmailId(ManageEmailUserDomain domain);
}
