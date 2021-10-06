package bg.softuni.Mobilelele.repository;

import bg.softuni.Mobilelele.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {


}
