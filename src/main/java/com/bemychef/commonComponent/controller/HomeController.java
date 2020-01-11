package com.bemychef.commonComponent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/getCountry")
    public ResponseEntity<String> getCountry() {
        return ResponseEntity.accepted().body("HELLO");
    }

    @RequestMapping(value = "/getCountry2")
    public ResponseEntity<String> getCountry2() {
        return ResponseEntity.accepted().body("NITIN");
    }
}
