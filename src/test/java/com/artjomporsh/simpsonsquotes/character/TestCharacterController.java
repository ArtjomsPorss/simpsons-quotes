package com.artjomporsh.simpsonsquotes.character;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class TestCharacterController {

    @Autowired
    private CharacterController characterController;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testIsControllerLoadedInContext(){
        assertThat(characterController)
                .withFailMessage("CharacterController is expected to be present in ApplicationContext but is not there.")
                .isNotNull();
    }

    @Test
    public void testHomePageIsReturned(){
        assertThat(this.characterController.home()).withFailMessage("index.html is expected to be returned").contains("index.html");
    }

    @Test
    public void testIsApplicationRunningOnPort8083(){
        assertThat(this.testRestTemplate.getForObject("http://localhost:8083/characters", List.class))
                .withFailMessage("Call to port 8083 for characters URL must return a non-null result").isNotNull();
    }


}
