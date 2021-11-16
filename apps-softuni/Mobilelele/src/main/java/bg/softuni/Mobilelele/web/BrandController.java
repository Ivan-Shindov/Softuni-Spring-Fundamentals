package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/brands/all")
    public String getAllBrands(Model model) {

        return "brands";
    }
}
