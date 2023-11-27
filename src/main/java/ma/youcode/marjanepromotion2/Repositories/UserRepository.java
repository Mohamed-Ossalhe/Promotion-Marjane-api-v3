package ma.youcode.marjanepromotion2.Repositories;

import ma.youcode.marjanepromotion2.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findUserByEmail(String email);
}
