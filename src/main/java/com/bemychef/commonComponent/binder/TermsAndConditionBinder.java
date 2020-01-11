package com.bemychef.commonComponent.binder;

import org.springframework.stereotype.Component;

import com.bemychef.commonComponent.dto.TermsAndConditionDto;
import com.bemychef.commonComponent.model.TermsAndCondition;

@Component
public class TermsAndConditionBinder {

	public TermsAndConditionDto termsModelToDto(TermsAndCondition terms) {
		TermsAndConditionDto termsDto=new TermsAndConditionDto();
		termsDto.setId(terms.getId());
		termsDto.setTermsAndConditionMessage(terms.getTerms());
		termsDto.setStatus(terms.getStatus());
		return termsDto;
	}
}
