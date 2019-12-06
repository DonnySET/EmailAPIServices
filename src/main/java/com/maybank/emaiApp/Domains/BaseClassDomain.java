package com.maybank.emaiApp.Domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseClassDomain {

	private String responseCode;
	private String responseMessageIn;
	private String responseMessageEn;
	
	
	public void setResponseMessage(String responseCode, String inMessage, String enMessage) {
		this.responseCode = responseCode;
		this.responseMessageEn = enMessage;
		this.responseMessageIn = inMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessageIn() {
		return responseMessageIn;
	}
	public void setResponseMessageIn(String responseMessageIn) {
		this.responseMessageIn = responseMessageIn;
	}
	public String getResponseMessageEn() {
		return responseMessageEn;
	}
	public void setResponseMessageEn(String responseMessageEn) {
		this.responseMessageEn = responseMessageEn;
	}
}
