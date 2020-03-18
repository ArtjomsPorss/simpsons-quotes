package com.artjomporsh.simpsonsquotes.character;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SimpsonsCharacterRepository extends Repository<SimpsonsCharacter, String> {

    @Transactional(readOnly=true)
    @Cacheable("characters")
    List<SimpsonsCharacter> findAll() throws DataAccessException;
}
