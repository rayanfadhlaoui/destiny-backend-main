package com.learning.springsecuritybasic.controller.character;

import com.learning.springsecuritybasic.controller.MessageResponse;
import com.learning.springsecuritybasic.exception.character.CharacterExistException;
import com.learning.springsecuritybasic.model.dto.character.CharacterDto;
import com.learning.springsecuritybasic.service.character.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<MessageResponse> getCharacters() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Admin informations");
        return ResponseEntity.ok(messageResponse);
    }

    @GetMapping("/myCharacter/{username}")
    public ResponseEntity<CharacterDto> getMyCharacter(@PathVariable String username) {
        return characterService.findMainCharacter(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/myCharacter")
    public ResponseEntity<CharacterDto> postMyCharacter(@RequestBody CharacterDto characterRequest) {
        try {
            var characterResponse =  characterService.createCharacter(characterRequest);
            return ResponseEntity.ok(characterResponse);
        } catch (CharacterExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
