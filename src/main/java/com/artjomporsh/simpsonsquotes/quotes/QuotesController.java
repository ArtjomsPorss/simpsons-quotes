package com.artjomporsh.simpsonsquotes.quotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuotesController {

    Logger LOG = LoggerFactory.getLogger(QuotesController.class);

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping(path = "/quotes/{id}")
    public @ResponseBody List<Quote> findQuotesForCharacter(@PathVariable("id") String characterId) {
        return quotesRepository.findByCharacterId(characterId);
    }

    @PostMapping("/saveQuote")
    public void saveQuote(@RequestBody Quote quote) {
        int hash = quote.hashCode();
        quote.set_id(""+hash);
        LOG.info(quote.toString());
        quotesRepository.save(quote);
    }

}
