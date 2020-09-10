package com.satooru.javaSays.service;

import java.util.List;

import com.satooru.javaSays.model.Quote;

public interface QuoteService {
    Quote findRandomQuote();
    Quote findLatestQuote();
    List<Quote> findAll();
    void saveQuote(Quote quote);
    void deleteQuote(String quote);
}
