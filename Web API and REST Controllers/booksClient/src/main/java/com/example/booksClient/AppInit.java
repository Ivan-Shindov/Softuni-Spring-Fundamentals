package com.example.booksClient;

import com.example.booksClient.model.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppInit implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppInit.class);
    private final RestTemplate restTemplate;

    public AppInit(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) {
        ResponseEntity<BookDTO[]> booksResponse = restTemplate
                .getForEntity("http://localhost:8080/books", BookDTO[].class);

        if (booksResponse.hasBody()) {
            BookDTO[] books = booksResponse.getBody();
            for (BookDTO book: books) {
                logger.info("Book that came from the server: {} with author: {}", book, book.getAuthor());
            }
        } else {
            logger.warn("Response doesn't have body.");
        }
    }
}
