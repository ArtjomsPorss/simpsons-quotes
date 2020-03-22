package com.artjomporsh.simpsonsquotes.quotes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuotesController.class)
public class TestQuotesController {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private QuotesRepository quotesRepository;

    @Test
    public void testIsControllerLoaded() {
        assertThat(mockMvc).withFailMessage("Mock Mvc Controller must be loaded").isNotNull();
    }

    @Test
    public void testFindQuotesForCharacter_id_passed() throws Exception {
        this.mockMvc.perform(get("/quotes/someid"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindQuotesForCharacter_nothing_passed() throws Exception {
        this.mockMvc.perform(get("/quotes/"))
                .andDo(print())
                .andExpect(status().isNotFound());
                        //HttpStatus.NOT_FOUND));
    }
}
