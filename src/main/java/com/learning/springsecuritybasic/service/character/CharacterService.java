package com.learning.springsecuritybasic.service.character;

import com.learning.springsecuritybasic.adapter.persistence.character.CharacterPersistenceAdapter;
import com.learning.springsecuritybasic.exception.character.CharacterExistException;
import com.learning.springsecuritybasic.mapper.character.CharacterMapper;
import com.learning.springsecuritybasic.model.dto.character.CharacterDto;
import com.learning.springsecuritybasic.model.persistence.character.CharacterEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterPersistenceAdapter characterPersistenceAdapter;
    private final CharacterMapper characterMapper;

    public CharacterService(CharacterPersistenceAdapter characterPersistenceAdapter,
                            CharacterMapper characterMapper) {
        this.characterPersistenceAdapter = characterPersistenceAdapter;
        this.characterMapper = characterMapper;
    }

    @Transactional
    public Optional<CharacterDto> findMainCharacter(String username) {
        return characterPersistenceAdapter.findByUsername(username)
                .stream()
                .findFirst()
                .map(characterMapper::entityToDto);
    }

    @Transactional
    public CharacterDto createCharacter(CharacterDto character) {
        if(findMainCharacter(character.getUsername()).isPresent()) {
            throw new CharacterExistException();
        }
        CharacterEntity characterEntity = characterMapper.dtoToEntity(character);
        CharacterEntity saveEntity = characterPersistenceAdapter.save(characterEntity);
        character.setId(saveEntity.getId());
        return character;
    }
}
