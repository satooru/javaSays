package com.satooru.javaSays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satooru.javaSays.model.Quote;
import com.satooru.javaSays.repository.interfaces.QuoteRepository;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote findRandomQuote() {
        return quoteRepository.findRandomQuote();
    }

    public Quote findLatestQuote() {
        return quoteRepository.findLatestQuote();
    }

    @Override
    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    @Override
    public void saveQuote(Quote quote) {
        quoteRepository.save(quote);
    }

    @Override
    public void deleteQuote(String quote) {
        quoteRepository.delete(quote);
    }
}
