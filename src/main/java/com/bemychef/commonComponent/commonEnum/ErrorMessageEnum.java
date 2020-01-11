package com.bemychef.commonComponent.commonEnum;

import java.io.Serializable;
import java.util.Arrays;

import com.bemychef.commonComponent.fileReader.ErrorPropertiesfileReader;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorMessageEnum implements Serializable{

	
	INVALID_EMAIL("C60001",""),
	EMAIL_ALREADY_REGISTER("C60002",""),
	CONTACT_ALREADY_REGISTER("C60003",""),
	INVALID_USERNAME("C60004",""),
	INVALID_OTP("C60005",""),
	INACTIVE_USER("C60006","");
	
	
	
	  private final String errorCode;
	  private final String errorMessage;
	
	  ErrorMessageEnum(final String  errorCode,final String errorMessage) {
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return ErrorPropertiesfileReader.getDataByKey(this.name());
	}
	  
	 @JsonCreator
	 static ErrorMessageEnum findValue(@JsonProperty("errorCode") String errorCode, @JsonProperty("errorMessage") String errorMessage){
	 
		 return Arrays.stream(ErrorMessageEnum.values()).filter(v -> v.errorCode == errorCode && v.errorMessage.equals(errorMessage)).findFirst().get();
	 }
}
