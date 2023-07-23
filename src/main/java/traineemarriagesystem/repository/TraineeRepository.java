package traineemarriagesystem.repository;

import org.springframework.stereotype.Repository;
import traineemarriagesystem.model.Trainee;

@Repository
public interface TraineeRepository extends UserRepository{
    Trainee findTraineeByEmail(String email);

    Trainee findTraineeByUsername(String username);
}
