package com.example.musicdbapp.service.impl;

import com.example.musicdbapp.model.entity.AlbumEntity;
import com.example.musicdbapp.model.entity.ArtistEntity;
import com.example.musicdbapp.model.entity.UserEntity;
import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import com.example.musicdbapp.model.service.AddAlbumServiceModel;
import com.example.musicdbapp.model.service.UserRegisterServiceModel;
import com.example.musicdbapp.model.view.AlbumViewModel;
import com.example.musicdbapp.repository.AlbumRepository;
import com.example.musicdbapp.security.CurrentUser;
import com.example.musicdbapp.service.AlbumService;
import com.example.musicdbapp.service.ArtistService;
import com.example.musicdbapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ArtistService artistService;
    private final CurrentUser currentUser;

    public AlbumServiceImpl(AlbumRepository albumRepository,
                            ModelMapper modelMapper, UserService userService,
                            ArtistService artistService, CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.artistService = artistService;
        this.currentUser = currentUser;
    }

    @Override
    public void addAlbum(AddAlbumServiceModel serviceModel) {
        UserEntity user = userService.findByUsername(currentUser.getUsername());

        AlbumEntity album = modelMapper.map(serviceModel, AlbumEntity.class);

        ArtistEntity artist = artistService.findByName(serviceModel.getArtist());
        album.setArtist(artist);
        album.setAddedFrom(user);

        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> findAllAlbumsOrderDescByCopies() {

        List<AlbumEntity> albums = albumRepository.findAllSortedDescByCopies();

        List<AddAlbumServiceModel> serviceModels = albums.stream()
                .map(albumEntity -> modelMapper.map(albumEntity, AddAlbumServiceModel.class))
                .collect(Collectors.toList());

        return serviceModels.stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public Long getCountAllCopies() {

        return albumRepository.getAllTotalCopies().orElse(null);
    }

    @Override
    public void deleteAlbum(Long id) {

        albumRepository.deleteById(id);


    }
}
