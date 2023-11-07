package com.learning.springsecuritybasic.mapper.character;

import com.learning.springsecuritybasic.model.dto.character.CharacterDto;
import com.learning.springsecuritybasic.model.persistence.character.CharacterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(source = "character.username", target = "username")
    CharacterDto entityToDto(CharacterEntity character);
    CharacterEntity dtoToEntity(CharacterDto characterDto);
}
