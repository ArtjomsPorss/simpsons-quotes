package com.artjomporsh.simpsonsquotes.character;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CharacterController {

    Logger LOG = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    private SimpsonsCharacterRepository characterRepo;

    @Autowired
    private SimpsonsCharacterMongoRepository characterMongoRepo;

    @GetMapping(path = "/")
    public String home(){
        return "index.html";
    }

    @GetMapping(path = "/characters")
    public @ResponseBody List<SimpsonsCharacter> getAllCharacters() {
        List<SimpsonsCharacter> characters = characterMongoRepo.findAll();
        LOG.info(characters.toString());
        return characters;
    }

}
