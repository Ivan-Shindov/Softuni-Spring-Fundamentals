package com.example.musicdbapp.web;

import com.example.musicdbapp.model.view.AlbumViewModel;
import com.example.musicdbapp.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        List<AlbumViewModel> viewModels = albumService.findAllAlbumsOrderDescByCopies();
        Long copies = albumService.getCountAllCopies();

        model.addAttribute("viewModelsOrdered", viewModels);
        model.addAttribute("copies", copies);

        return "home";
    }

    @GetMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {

        albumService.deleteAlbum(id);

        return "redirect:/home";
    }

}
