package bg.softuni.Mobilelele.service;

import bg.softuni.Mobilelele.model.entity.Brand;
import bg.softuni.Mobilelele.model.entity.Model;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    Brand findByBrandOrCreate(String brand);

    Brand addModel(Model model, Brand brand);

    List<String> getAllBrandNames();
}
