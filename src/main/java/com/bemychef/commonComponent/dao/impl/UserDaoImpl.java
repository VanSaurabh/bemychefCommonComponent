package com.bemychef.commonComponent.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bemychef.commonComponent.commonEnum.StatusEnum;
import com.bemychef.commonComponent.dao.UserDao;
import com.bemychef.commonComponent.model.UserModel;


@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long checkIfEmailAlreadyExists(String emailId) {
		Query query = em.createQuery("SELECT u FROM UserModel u WHERE u.email = :emailId");
		query.setParameter("emailId", emailId);
		return query.getResultList().size();
	}
	
	
	@Override
	public long checkOtpByUserName(String username,String otp) {
		Query query = em.createQuery("SELECT u FROM UserModel u WHERE u.otp = :otp AND (u.email=:username OR u.contact=:username)");
		query.setParameter("otp", otp);
		query.setParameter("username", username);
	

		return query.getResultList().size();
	}
	

	@Override
	@Transactional
	public void updateStatusOfUserByUserId(String username, StatusEnum status) {
		Query query = em.createQuery("UPDATE UserModel u SET u.status = :status WHERE u.email = :username OR u.contact=:username");
		query.setParameter("status", status);
		query.setParameter("username", username);
		//em.joinTransaction();
		query.executeUpdate();
		
	}

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT u FROM UserModel u WHERE u.password = :password AND (u.email=:username OR u.contact=:username)");
		query.setParameter("password", password);
		query.setParameter("username", username);
		List<UserModel> allData=query.getResultList();
		if(allData.size()>0) {
			return allData.get(0);
		}else {
			return null;
		}
		
	}


	@Override
	public long checkIfMobileAlreadyExists(String contact) {
		Query query = em.createQuery("SELECT u FROM UserModel u WHERE u.contact = :contact");
		query.setParameter("contact", contact);
		return query.getResultList().size();
	}


	
}
