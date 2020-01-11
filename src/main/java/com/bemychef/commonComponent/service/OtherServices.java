package com.bemychef.commonComponent.service;

import org.springframework.stereotype.Service;

import com.bemychef.commonComponent.dto.TermsAndConditionDto;
@Service
public interface OtherServices {
	public TermsAndConditionDto getTermsAndCondition();
}
