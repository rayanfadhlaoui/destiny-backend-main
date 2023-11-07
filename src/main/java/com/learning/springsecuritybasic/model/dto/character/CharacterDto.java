package com.learning.springsecuritybasic.model.dto.character;

import com.learning.springsecuritybasic.model.common.character.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDto {
    private int id;

    private String firstName;

    private String lastName;

    private String birthdate;

    private Gender gender;

    private String username;

    private RaceDto race;
}