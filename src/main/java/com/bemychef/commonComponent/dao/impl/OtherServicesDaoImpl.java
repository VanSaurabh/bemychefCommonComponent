package com.bemychef.commonComponent.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bemychef.commonComponent.commonEnum.StatusEnum;
import com.bemychef.commonComponent.dao.OtherServicesDao;
import com.bemychef.commonComponent.model.TermsAndCondition;

@Repository
public class OtherServicesDaoImpl implements OtherServicesDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public TermsAndCondition getTerms() {
		Query query = em.createQuery("SELECT t FROM TermsAndCondition t WHERE t.status = :status");
		query.setParameter("status", StatusEnum.ACTIVE);
		List<TermsAndCondition> terms=query.getResultList();
		if(terms.size()>0) {
			return terms.get(0);
		}else {
			return null;
		}
	}

	
}
