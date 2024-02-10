package nl.novi.opdrachttechiteasy.repositories;

import nl.novi.opdrachttechiteasy.models.Televisions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Televisions,Long> {
    List<Televisions> findByBrand(String brand);
}
