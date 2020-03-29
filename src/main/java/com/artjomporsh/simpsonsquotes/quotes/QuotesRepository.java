package com.artjomporsh.simpsonsquotes.quotes;

import java.util.List;

public interface QuotesRepository {
    List<Quote> findByCharacterId(String id);

    void save (Quote quote);
}
