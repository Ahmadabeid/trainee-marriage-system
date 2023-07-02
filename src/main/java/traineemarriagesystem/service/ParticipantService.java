package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Participant;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.ParticipantRepository;
import traineemarriagesystem.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;


    public Participant addParticipant(String firstname,String middleName, String lastname,
                                      String username, String email, String address,String age, String gender, String password,
                                      String phoneNumber,String qualification,String status){
        Participant participant=new Participant();
        participant.setFirstName(firstname);
        participant.setMiddleName(middleName);
        participant.setLastName(lastname);
        participant.setUsername(username);
        participant.setEmail(email);
        participant.setAddress(address);
        participant.setAge(age);
        participant.setGender(gender);
        participant.setPassword(password);
        participant.setPhoneNumber(phoneNumber);
        participant.setQualification(qualification);
        participant.setStatus(status);

        return participantRepository.save(participant);
    }

 //delete by id
    public void deleteParticipantById(Long userID){
        participantRepository.deleteById(userID);
    }


//    view all participant
    public List<User> getParticipants(){
        return participantRepository.findAll();
    }




//        view by id
    public Participant getParticipantById(Long userID){
        return (Participant) participantRepository.findById(userID).get();
    }

//update    Participant
 public Participant updateParticipant(Long  userId,String firstName,String middleName,String lastNme,
                                      String username, String email, String address,String age, String gender,
                                      String password, String phoneNumber, String qualification,String status){

        Participant participant = getParticipantById(userId);
     participant.setFirstName(firstName);
     participant.setMiddleName(middleName);
     participant.setLastName(lastNme);
     participant.setUsername(username);
     participant.setEmail(email);
     participant.setAddress(address);
     participant.setAge(age);
     participant.setGender(gender);
     participant.setPassword(password);
     participant.setPhoneNumber(phoneNumber);
     participant.setQualification(qualification);
     participant.setStatus(status);

     return participantRepository.save(participant);

 }






}
