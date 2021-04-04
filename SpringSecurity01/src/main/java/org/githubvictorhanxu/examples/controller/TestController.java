package org.githubvictorhanxu.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //@Autowired
    //PasswordEncoder encoder;

    @GetMapping("/security")
    public String hello () {
        return "Hello, This is Spring Security!!!";
    }

}
