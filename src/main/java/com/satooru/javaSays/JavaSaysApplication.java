package com.satooru.javaSays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satooru.javaSays.model.Quote;
import com.satooru.javaSays.repository.interfaces.QuoteRepository;

@SpringBootApplication
public class JavaSaysApplication implements CommandLineRunner {

    @Autowired
    private QuoteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JavaSaysApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        repository.save(new Quote("Just do it!"));
        repository.save(new Quote("Make your dreams come true!"));
    }
}
