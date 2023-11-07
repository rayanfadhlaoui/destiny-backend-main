package com.learning.springsecuritybasic.controller.land;

import com.learning.springsecuritybasic.controller.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandController {

    @GetMapping("/lands")
    public ResponseEntity<MessageResponse> getLands() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("The lands");
        return ResponseEntity.ok(messageResponse);
    }
}
