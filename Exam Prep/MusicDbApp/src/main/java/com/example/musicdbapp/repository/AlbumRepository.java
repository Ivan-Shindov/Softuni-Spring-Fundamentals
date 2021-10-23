package com.example.musicdbapp.repository;

import com.example.musicdbapp.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity,Long> {

    @Query("SELECT a FROM AlbumEntity a ORDER BY a.copies")
    List<AlbumEntity> findAllSortedDescByCopies();

    @Query("SELECT sum(a.copies) FROM AlbumEntity a")
    long getAllTotalCopies();

}
