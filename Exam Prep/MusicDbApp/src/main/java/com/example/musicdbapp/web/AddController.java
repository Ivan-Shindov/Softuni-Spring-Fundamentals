package com.example.musicdbapp.web;

import com.example.musicdbapp.model.binding.AlbumAddBindingModel;
import com.example.musicdbapp.model.service.AddAlbumServiceModel;
import com.example.musicdbapp.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AddController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AddController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/album/add")
    public String addAlbum(@Valid AlbumAddBindingModel albumAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel",bindingResult)
                    .addFlashAttribute("albumAddBindingModel",albumAddBindingModel);

            return "redirect:/album/add";
        }


        albumService.addAlbum(modelMapper.map(albumAddBindingModel, AddAlbumServiceModel.class));


        return "redirect:/home";
    }

    @GetMapping("/album/add")
    public String getAlbum(Model model) {

        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
        }

        return "add-album";
    }

}
