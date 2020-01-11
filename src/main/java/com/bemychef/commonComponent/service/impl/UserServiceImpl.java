package com.bemychef.commonComponent.service.impl;


import com.bemychef.commonComponent.binder.UserBinder;
import com.bemychef.commonComponent.common.EmailBody;
import com.bemychef.commonComponent.commonEnum.ErrorMessageEnum;
import com.bemychef.commonComponent.commonEnum.StatusEnum;
import com.bemychef.commonComponent.commonEnum.SuccessMessageEnum;
import com.bemychef.commonComponent.commonServices.CommonService;
import com.bemychef.commonComponent.dao.UserDao;
import com.bemychef.commonComponent.dto.UserDto;
import com.bemychef.commonComponent.model.UserModel;
import com.bemychef.commonComponent.repository.UserRepository;
import com.bemychef.commonComponent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CommonService commonService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBinder userBinder;

    @Autowired
    private UserRepository userRepo;

    @Override
    public ResponseEntity<Object> registerUser(UserDto userDTO) {

        if (userDTO.getEmail() == null && userDTO.getContact() == null) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_EMAIL);

        } else if (checkIfUserWithGivenEmailExists(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.EMAIL_ALREADY_REGISTER);
        } else if (checkIfUserWithGivenContactExists(userDTO.getContact())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.CONTACT_ALREADY_REGISTER);
        } else {

            String otp = commonService.generateOTP();
            UserModel user = userBinder.bindUserDTOToUserModel(userDTO);
            user.setStatus(StatusEnum.INACTIVE);
            user.setOtp(otp);
            //send email
            commonService.sendMessage(user.getEmail(), EmailBody.OTP_MAIL + otp);
            userRepo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(SuccessMessageEnum.REGISTRATION_SUCCESS);
        }
    }


    private boolean checkIfUserWithGivenEmailExists(String emailId) {

        return userDao.checkIfEmailAlreadyExists(emailId) != 0;
    }

    private boolean checkIfUserWithGivenContactExists(String contact) {

        return userDao.checkIfMobileAlreadyExists(contact) != 0;
    }


    @Override
    public ResponseEntity<Object> verifyUserName(String username, String otp) {
        if (username == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_USERNAME);
        } else if (otp == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_OTP);
        } else if (!checkIfUserWithGivenEmailExists(username)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_EMAIL);
        } else if (userDao.checkOtpByUserName(username, otp) <= 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_OTP);
        } else {
            userDao.updateStatusOfUserByUserId(username, StatusEnum.ACTIVE);
            return ResponseEntity.status(HttpStatus.OK).body(SuccessMessageEnum.ACCOUNT_VERIFIED);
        }
    }


    @Override
    public ResponseEntity<Object> userLogin(String username, String password) {
        if (username == null && password == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_USERNAME);
        } else {
            UserModel user = userDao.login(username, password);

            if (user == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INVALID_USERNAME);
            } else if (user.getStatus().equals(StatusEnum.INACTIVE)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessageEnum.INACTIVE_USER);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(SuccessMessageEnum.LOGIN_SUCCESS);
            }

        }

    }


}
