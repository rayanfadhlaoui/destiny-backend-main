package com.learning.springsecuritybasic.model.dto.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterCreationRequest {
    private CharacterDto character;
    private String userName;
}
