package com.artjomporsh.simpsonsquotes.quotes;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuotesRepository extends MongoRepository<Quote, String> {

    List<Quote> findByCharacter(String character);

    Quote insert (Quote quote);
}
