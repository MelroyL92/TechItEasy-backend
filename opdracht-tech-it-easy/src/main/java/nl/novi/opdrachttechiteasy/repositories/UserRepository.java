package nl.novi.opdrachttechiteasy.repositories;

import nl.novi.opdrachttechiteasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
