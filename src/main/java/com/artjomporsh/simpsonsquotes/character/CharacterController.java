package com.artjomporsh.simpsonsquotes.character;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CharacterController {
    @GetMapping(path = "/")
    public String home(){
        return "index.html";
    }

    @GetMapping(path = "/characters")
    public @ResponseBody List<SimpsonsCharacter> getAllCharacters() {
        return Arrays.asList(new SimpsonsCharacter());
    }
}
