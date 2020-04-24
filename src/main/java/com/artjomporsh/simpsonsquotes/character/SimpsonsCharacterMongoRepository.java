package com.artjomporsh.simpsonsquotes.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpsonsCharacterMongoRepository {

    @Autowired
    MongoTemplate template;

    public List<SimpsonsCharacter> findAll() {
        return template.findAll(SimpsonsCharacter.class);
    }

}
