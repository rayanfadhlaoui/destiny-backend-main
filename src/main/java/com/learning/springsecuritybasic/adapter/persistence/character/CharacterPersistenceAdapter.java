package com.learning.springsecuritybasic.adapter.persistence.character;

import com.learning.springsecuritybasic.model.persistence.character.CharacterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterPersistenceAdapter extends CrudRepository<CharacterEntity, Integer> {

    List<CharacterEntity> findByUsername(String username);
}
