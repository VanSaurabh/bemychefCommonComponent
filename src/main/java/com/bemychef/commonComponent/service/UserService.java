package com.bemychef.commonComponent.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bemychef.commonComponent.dto.UserDto;

@Service
public interface UserService {
	ResponseEntity<Object> registerUser(UserDto userDTO);
	
	ResponseEntity<Object> verifyUserName(String username,String otp);
	
	ResponseEntity<Object> userLogin(String username,String password);
	
}
