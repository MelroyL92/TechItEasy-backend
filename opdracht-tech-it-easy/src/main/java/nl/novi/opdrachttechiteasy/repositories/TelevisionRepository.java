package nl.novi.opdrachttechiteasy.repositories;

import nl.novi.opdrachttechiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television,Long> {
    List<Television> findByBrand(String brand);
    List<Television> findByType(String type);
    void deleteByBrand(String television);


}
