package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Trainee;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.TraineeRepository;
import traineemarriagesystem.repository.UserRepository;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class TraineeService {
    public  String generateRegistrationNumber(){
        String regNo="Mufti/8/20/";
        for (int i= 0; i<8;i++){
            int no = new Random().nextInt(9);
            regNo+= String.valueOf(no);
        }
        return regNo;
    }

    private final TraineeRepository traineeRepository;
    private final UserRepository userRepository;

    public Trainee addTrainee(String firstname,String middleName, String lastname,
    String username, String email, String address,String age, String gender, String password,
                              String phoneNumber,String regNo){

        Trainee trainee=new Trainee();
        trainee.setFirstName(firstname);
        trainee.setMiddleName(middleName);
        trainee.setLastName(lastname);
        trainee.setUsername(username);
        trainee.setEmail(email);
        trainee.setAddress(address);
        trainee.setAge(age);
        trainee.setGender(gender);
        trainee.setPassword(password);
        trainee.setPhoneNumber(phoneNumber);
        trainee.setRegNo(regNo);

        return traineeRepository.save(trainee);
    }

//    delete by id
    public void deleteTraineeById(Long userID){
        traineeRepository.deleteById(userID);
    }

//    get trainees
    public List<User> getTrainees(){
        return traineeRepository.findAll();
    }

// get trainee by id


    public Trainee getTraineeById(Long traineeId){
        return (Trainee) traineeRepository.findById(traineeId).get();
    }



//    update trainee
    public Trainee updateTrainee(Long  traineeId,String firstName,String middleName,String lastNme,
                                  String username, String email, String address,String age, String gender,
                                  String password,String phoneNumber,String regNo){
        Trainee trainee= (Trainee) getTraineeById(traineeId);
        trainee.setFirstName(firstName);
        trainee.setMiddleName(middleName);
        trainee.setLastName(lastNme);
        trainee.setUsername(username);
        trainee.setEmail(email);
        trainee.setAddress(address);
        trainee.setAge(age);
        trainee.setGender(gender);
        trainee.setPassword(password);
        trainee.setPhoneNumber(phoneNumber);
        trainee.setRegNo(regNo);

        return traineeRepository.save(trainee);
    }

}
