package com.bemychef.commonComponent.binder;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bemychef.commonComponent.dto.UserDto;
import com.bemychef.commonComponent.model.UserModel;

@Component
public class UserBinder {

	
	public UserModel bindUserDTOToUserModel(UserDto userDTO) {
		UserModel user=new UserModel();
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setContact(userDTO.getContact());
		user.setName(userDTO.getName());
		user.setDeviceToken(userDTO.getDeviceToken());
		user.setDeviceType(userDTO.getDeviceType());
		user.setAppType(userDTO.getAppType());
		return user;
	}
	
	public Timestamp getTimeStamp() {
		Date date = new Date();
		Long time = date.getTime();
		return new Timestamp(time);
	}
}
