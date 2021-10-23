package com.example.musicdbapp.service;

import com.example.musicdbapp.model.entity.ArtistEntity;
import com.example.musicdbapp.model.entity.enums.ArtistEnum;

public interface ArtistService {
    ArtistEntity findByName(ArtistEnum artist);
}
