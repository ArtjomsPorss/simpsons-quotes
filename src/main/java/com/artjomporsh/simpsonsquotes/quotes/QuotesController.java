package com.artjomporsh.simpsonsquotes.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuotesController {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping(path = "/quotes/{id}")
    public @ResponseBody
    List<Quote> findQuotesForCharacter(@PathVariable("id") String characterId) {
        return quotesRepository.findByCharacterId(characterId);
    }
}
