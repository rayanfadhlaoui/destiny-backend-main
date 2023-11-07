package com.learning.springsecuritybasic.controller.army;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmyController {

    @GetMapping("/armies")
    public String getArmies() {
        return "The armies";
    }
}
