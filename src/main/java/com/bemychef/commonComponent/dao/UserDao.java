package com.bemychef.commonComponent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bemychef.commonComponent.commonEnum.StatusEnum;
import com.bemychef.commonComponent.model.UserModel;




@Repository
public interface UserDao {
	
	long checkIfEmailAlreadyExists(String emailId);
	
	long checkIfMobileAlreadyExists(String contact);
	
	long checkOtpByUserName(String username,String otp);
	
	void updateStatusOfUserByUserId(String username, StatusEnum status);
	
	UserModel login(String username, String password);
}
