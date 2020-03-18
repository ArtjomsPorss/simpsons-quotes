package com.artjomporsh.simpsonsquotes.character;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCharacterRepository {

    @Autowired
    private SimpsonsCharacterRepository characterRepository;

    @Test
    public void testGetAllCharactersReturnIsNotNull() {
        assertThat(characterRepository.findAll()).withFailMessage("Find All Characters must not be null").isNotNull();
    }
}
