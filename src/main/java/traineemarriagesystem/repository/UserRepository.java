package traineemarriagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import traineemarriagesystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserRepository findUserByUsername(String username);
}
