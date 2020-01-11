package com.bemychef.commonComponent.controller;

import com.bemychef.commonComponent.dto.UserDto;
import com.bemychef.commonComponent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registration(@RequestBody UserDto userdto) {

        return userService.registerUser(userdto);
    }


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> json) {

        return userService.userLogin(json.get("username"), json.get("password"));
    }

    @PostMapping("/test")
    public ResponseEntity<Object> test(String username, String otp) {

        return userService.verifyUserName(username, otp);
    }

    @PostMapping("/verify")
    public ResponseEntity<Object> userVerify(@RequestBody Map<String, String> json) {
        return userService.verifyUserName(json.get("username"), json.get("otp"));
    }


}
