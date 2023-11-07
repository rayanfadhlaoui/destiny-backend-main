package com.learning.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public MessageResponse sayWelcome() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Welcome to Spring Application with security");
        return messageResponse;
    }
}
