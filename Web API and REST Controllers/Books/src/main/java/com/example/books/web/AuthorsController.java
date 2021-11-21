package com.example.books.web;

import com.example.books.model.dto.AuthorDTO;
import com.example.books.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {

        List<AuthorDTO> allAuthors = authorService.findAllAuthors();

        return ResponseEntity.ok(allAuthors);
    }
}
