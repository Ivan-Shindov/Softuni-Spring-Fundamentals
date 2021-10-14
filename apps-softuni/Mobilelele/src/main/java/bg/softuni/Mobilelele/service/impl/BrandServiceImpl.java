package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.Brand;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
