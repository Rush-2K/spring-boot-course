package com.luv2code.springboot.cruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {

        // return "plain-login";
        return "fancy-login";
    }

    // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
