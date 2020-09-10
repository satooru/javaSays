package com.satooru.javaSays.repository.interfaces;

import com.satooru.javaSays.model.Quote;

public interface QuoteRepositoryCustom {
    Quote findRandomQuote();
    Quote findLatestQuote();
    void delete(String quote);
}
