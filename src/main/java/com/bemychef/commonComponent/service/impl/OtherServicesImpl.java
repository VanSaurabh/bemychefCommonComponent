package com.bemychef.commonComponent.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bemychef.commonComponent.binder.TermsAndConditionBinder;
import com.bemychef.commonComponent.dao.OtherServicesDao;
import com.bemychef.commonComponent.dto.TermsAndConditionDto;
import com.bemychef.commonComponent.service.OtherServices;
@Service
public class OtherServicesImpl implements OtherServices{

	@Autowired
	OtherServicesDao otherServices;
	
	@Autowired
	TermsAndConditionBinder termsBinder;
	
	@Override
	public TermsAndConditionDto getTermsAndCondition() {
		return termsBinder.termsModelToDto(otherServices.getTerms());
	}

}
