package com.example.musicdbapp.service.impl;

import com.example.musicdbapp.model.entity.ArtistEntity;
import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import com.example.musicdbapp.repository.ArtistRepository;
import com.example.musicdbapp.service.ArtistService;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public ArtistEntity findByName(ArtistEnum artist) {

        return artistRepository.findByName(artist).orElse(null);

    }
}
