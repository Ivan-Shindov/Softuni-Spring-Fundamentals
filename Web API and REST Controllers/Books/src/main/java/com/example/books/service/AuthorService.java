package com.example.books.service;

import com.example.books.model.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> findAllAuthors();
}
