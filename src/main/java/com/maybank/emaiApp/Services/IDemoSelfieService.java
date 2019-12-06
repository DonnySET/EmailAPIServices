package com.maybank.emaiApp.Services;

import com.maybank.emaiApp.Domains.BaseClassDomain;
import com.maybank.emaiApp.Domains.Impl.DemoSelfieDomain;

public interface IDemoSelfieService {
	DemoSelfieDomain addDemo(DemoSelfieDomain requestData);
}
