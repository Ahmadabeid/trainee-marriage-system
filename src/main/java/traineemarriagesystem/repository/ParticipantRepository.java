package traineemarriagesystem.repository;

import org.springframework.stereotype.Repository;
import traineemarriagesystem.model.User;

@Repository
public interface ParticipantRepository extends UserRepository{

    User findParticipantByUsername(String username);

    User findParticipantByEmail(String email);
}
