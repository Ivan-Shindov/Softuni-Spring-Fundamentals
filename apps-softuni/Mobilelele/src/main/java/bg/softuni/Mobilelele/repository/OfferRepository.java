package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

    Optional<Offer> findById(long id);
}
