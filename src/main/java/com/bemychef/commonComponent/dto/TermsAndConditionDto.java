package com.bemychef.commonComponent.dto;

import com.bemychef.commonComponent.commonEnum.StatusEnum;

	public class TermsAndConditionDto {
	
		private Long id;
	 private String termsAndConditionMessage;
	 private StatusEnum status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTermsAndConditionMessage() {
		return termsAndConditionMessage;
	}
	public void setTermsAndConditionMessage(String termsAndConditionMessage) {
		this.termsAndConditionMessage = termsAndConditionMessage;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	 
	 
}
