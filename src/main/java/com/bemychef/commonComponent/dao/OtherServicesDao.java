package com.bemychef.commonComponent.dao;

import org.springframework.stereotype.Repository;

import com.bemychef.commonComponent.model.TermsAndCondition;
@Repository
public interface OtherServicesDao {

	public TermsAndCondition getTerms();
}
