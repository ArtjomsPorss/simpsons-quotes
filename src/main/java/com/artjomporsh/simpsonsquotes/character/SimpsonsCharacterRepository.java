package com.artjomporsh.simpsonsquotes.character;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SimpsonsCharacterRepository extends MongoRepository<SimpsonsCharacter, String> {

    List<SimpsonsCharacter> findAll() throws DataAccessException;
}
