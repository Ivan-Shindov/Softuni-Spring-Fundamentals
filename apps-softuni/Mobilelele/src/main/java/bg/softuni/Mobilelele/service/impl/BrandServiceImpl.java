package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.Brand;
import bg.softuni.Mobilelele.model.entity.Model;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            Brand brand = new Brand();
            brand.setName("BMW");

            Brand brand2 = new Brand();
            brand2.setName("Audi");

            Brand brand3 = new Brand();
            brand3.setName("Mercedes-Benz");

            brandRepository.saveAll(List.of(brand,brand2,brand3));
        }
    }

    @Override
    public Brand findByBrandOrCreate(String name) {

        Brand brand = brandRepository.findByName(name).orElse(null);

        if (brand == null) {
            Brand newBrand = new Brand();
            newBrand.setName(name);
            return newBrand;
        }

        return brand;
    }

    @Override
    public Brand addModel(Model model,Brand brand) {

        Set<Model> models = brand.getModels();
        models.add(model);

        return brand;
    }

    @Override
    public List<String> getAllBrandNames() {

        return brandRepository.findAllBrandNames();
    }
}
