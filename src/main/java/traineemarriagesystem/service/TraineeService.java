package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder passwordEncoder;

    public Trainee registerTrainee(Trainee trainee) {
        trainee.setRole("ROLE_STUDENT");
        return traineeRepository.save(trainee);
    }


    public Trainee addTrainee(String firstname,String middleName, String lastname,
    String username, String email,String gender, String password,String role,
                              String phoneNumber,String regNo,String pLaceOfBirth,
                              String dateOfBirth,String nationality,String district,
                              String ward,String employmentStatus,String maritalStatus,
                              String disability,String disabilityTitle, String educationalStatus){

        Trainee trainee=new Trainee();
        trainee.setFirstName(firstname);
        trainee.setMiddleName(middleName);
        trainee.setLastName(lastname);
        trainee.setUsername(username);
        trainee.setEmail(email);
        trainee.setGender(gender);
        trainee.setPassword(passwordEncoder.encode(password));
        trainee.setPhoneNumber(phoneNumber);
        trainee.setRegNo(regNo);
        trainee.setPLaceOfBirth(pLaceOfBirth);
        trainee.setDateOfBirth(dateOfBirth);
        trainee.setNationality(nationality);
        trainee.setDistrict(district);
        trainee.setWard(ward);
        trainee.setEmploymentStatus(employmentStatus);
        trainee.setMaritalStatus(maritalStatus);
        trainee.setDisability(disability);
        trainee.setDisabilityTitle(disabilityTitle);
        trainee.setEducationalStatus(educationalStatus);
        trainee.setRole(role);

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
                                  String username, String email, String gender,String role,
                                  String password,String phoneNumber,String regNo,String pLaceOfBirth,
                                 String dateOfBirth,String nationality,String district,
                                 String ward,String employmentStatus,String maritalStatus,
                                 String disability,String disabilityTitle, String educationalStatus){
        Trainee trainee= (Trainee) getTraineeById(traineeId);
        trainee.setFirstName(firstName);
        trainee.setMiddleName(middleName);
        trainee.setLastName(lastNme);
        trainee.setUsername(username);
        trainee.setEmail(email);
        trainee.setGender(gender);
        trainee.setPassword(passwordEncoder.encode(password));
        trainee.setPhoneNumber(phoneNumber);
        trainee.setRegNo(regNo);
        trainee.setPLaceOfBirth(pLaceOfBirth);
        trainee.setDateOfBirth(dateOfBirth);
        trainee.setNationality(nationality);
        trainee.setDistrict(district);
        trainee.setWard(ward);
        trainee.setEmploymentStatus(employmentStatus);
        trainee.setMaritalStatus(maritalStatus);
        trainee.setDisability(disability);
        trainee.setDisabilityTitle(disabilityTitle);
        trainee.setEducationalStatus(educationalStatus);
        trainee.setRole(role);

        return traineeRepository.save(trainee);
    }

    public Trainee findTraineeByUsername(String username){
        return traineeRepository.findTraineeByUsername(username);
    }

    public Trainee findTraineeByEmail(String email){
        return traineeRepository.findTraineeByEmail(email);
    }

}
