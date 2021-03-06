package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

    @Query("SELECT b.name FROM Brand b JOIN Model")
    List<String> findAllBrandNames();
}
