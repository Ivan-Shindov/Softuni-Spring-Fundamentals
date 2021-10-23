package com.example.musicdbapp.repository;

import com.example.musicdbapp.model.entity.ArtistEntity;
import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity,Long> {

    Optional<ArtistEntity> findByName(ArtistEnum artist);
}
