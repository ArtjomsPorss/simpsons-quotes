package com.artjomporsh.simpsonsquotes.quotes;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class QuotesRepositoryImpl implements QuotesRepository {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public List<Quote> findByCharacterId(String characterId) {
        TypedQuery<Quote> quotes = em.createQuery("SELECT q FROM Quote q WHERE q.character =: characterId", Quote.class);
        quotes.setParameter("characterId", characterId);
        return quotes.getResultList();
    }

    @Override
    @Transactional
    public void save(Quote quote) {
        em.merge(quote);
        em.flush();
    }


}
