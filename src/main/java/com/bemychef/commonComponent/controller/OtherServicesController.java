package com.bemychef.commonComponent.controller;

import com.bemychef.commonComponent.dto.TermsAndConditionDto;
import com.bemychef.commonComponent.service.OtherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class OtherServicesController {

    @Autowired
    OtherServices otherServices;

    @GetMapping(value = "/termsandcondition")
    public String getTermsAndCondition(Model model) {
        TermsAndConditionDto termsAndCondition = otherServices.getTermsAndCondition();
        model.addAttribute("terms", termsAndCondition.getTermsAndConditionMessage());
        return "TermsAndCondition";

    }
}
