package com.satooru.javaSays.repository.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satooru.javaSays.model.Quote;
import com.satooru.javaSays.repository.interfaces.QuoteRepositoryCustom;

@Repository
public class QuoteRepositoryCustomImpl implements QuoteRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Quote findRandomQuote() {
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        AggregationResults<Quote> quote = mongoTemplate.aggregate(aggregation, "quotes", Quote.class);
        return quote.getUniqueMappedResult();
    }

    @Override
    public Quote findLatestQuote() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "timestamp"));
        return mongoTemplate.findOne(query, Quote.class);
    }

    @Override
    public void delete(String quote) {
        Query query = new Query();
        query.addCriteria(Criteria.where("quote").is(quote));
        mongoTemplate.findAndRemove(query, Quote.class);
    }
}
