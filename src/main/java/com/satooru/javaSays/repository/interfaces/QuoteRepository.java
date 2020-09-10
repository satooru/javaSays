package com.satooru.javaSays.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.satooru.javaSays.model.Quote;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, String>, QuoteRepositoryCustom{
    List<Quote> findAll();
    Quote save(Quote quote);
}
