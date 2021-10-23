package com.example.musicdbapp.service;

import com.example.musicdbapp.model.service.AddAlbumServiceModel;
import com.example.musicdbapp.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AddAlbumServiceModel serviceModel);

    List<AlbumViewModel> findAllAlbumsOrderDescByCopies();

    Long getCountAllCopies();

    void deleteAlbum(Long id);
}
