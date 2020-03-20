package com.artjomporsh.simpsonsquotes.character;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharacterController.class)
public class TestCharacterController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SimpsonsCharacterRepository repository;

    @Test
    public void testIsControllerLoadedInContext() {
        assertThat(mockMvc)
                .withFailMessage("CharacterController is expected to be present in ApplicationContext but is not there.")
                .isNotNull();
    }

    @Test
    public void testHomePageIsReturned() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(forwardedUrl("index.html"));
    }

    @Test
    public void testCharactersReturnsJsonArray() throws Exception {
        this.mockMvc.perform(get("/characters"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


}
