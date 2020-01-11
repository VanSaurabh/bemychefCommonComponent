package com.bemychef.commonComponent.commonEnum;

import java.io.Serializable;
import java.util.Arrays;

import com.bemychef.commonComponent.fileReader.UserSeccessMessagePropertiesFileReader;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SuccessMessageEnum implements Serializable{
	REGISTRATION_SUCCESS("C50001",""),
	ACCOUNT_VERIFIED("C50002",""),
	LOGIN_SUCCESS("C50003","");
	
	private final String successCode;
	  private final String successMessage;
	  SuccessMessageEnum(final String  successCode,final String successMessage) {
			this.successCode=successCode;
			this.successMessage=successMessage;
		}
	  
	  
	  public String getSuccessCode() {
			return successCode;
		}


		public String getSuccessMessage() {
			return UserSeccessMessagePropertiesFileReader.getDataByKey(this.name());
		}
		  
		 @JsonCreator
		 static SuccessMessageEnum findValue(@JsonProperty("successCode") String successCode, @JsonProperty("successMessage") String successMessage){
		 
			 return Arrays.stream(SuccessMessageEnum.values()).filter(v -> v.successCode == successCode && v.successMessage.equals(successMessage)).findFirst().get();
		 }
		  
}
