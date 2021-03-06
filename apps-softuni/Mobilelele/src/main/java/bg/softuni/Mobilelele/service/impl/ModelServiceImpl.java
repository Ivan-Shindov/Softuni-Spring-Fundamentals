package bg.softuni.Mobilelele.service.impl;

import bg.softuni.Mobilelele.model.entity.Brand;
import bg.softuni.Mobilelele.model.entity.Model;
import bg.softuni.Mobilelele.model.enums.CategoryEnum;
import bg.softuni.Mobilelele.repository.BrandRepository;
import bg.softuni.Mobilelele.repository.ModelRepository;
import bg.softuni.Mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }


    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {

            Brand bmw = brandRepository.findByName("BMW")
                    .orElseThrow(IllegalArgumentException::new);

            Brand mercedes = brandRepository.findByName("Mercedes-Benz")
                    .orElseThrow(IllegalArgumentException::new);

            Model x5 = new Model();
            x5
                    .setName("X5")
                    .setStartYear(2000)
                    .setEndYear(2021)
                    .setBrand(bmw)
                    .setMileage(12303)
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://kolalok.com/newimage/small/2018-x5-g05-bmw.jpg");

            Model s63 = new Model();
            s63
                    .setName("s63")
                    .setStartYear(1960)
                    .setEndYear(2021)
                    .setBrand(mercedes)
                    .setMileage(10000)
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://autodius.com/wp-content/uploads/2018/07/2018-mercedes-benz-s63-amg.jpg");

            Model gleCoupe = new Model();
            gleCoupe.setBrand(mercedes)
                    .setName("GLE-Coupe")
                    .setStartYear(2011)
                    .setEndYear(2021)
                    .setMileage(2031)
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://cdn.motor1.com/images/mgl/z2mo6/s1/mercedes-amg-gle-63-s-coupe.jpg");

            modelRepository.saveAll(List.of(gleCoupe,s63,x5));
        }
    }
}
