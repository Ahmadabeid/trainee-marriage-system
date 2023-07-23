package traineemarriagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import traineemarriagesystem.model.Trainee;
import traineemarriagesystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);


//    UserRepository findUserByEmail(String email);

//    String getPassword();
}
