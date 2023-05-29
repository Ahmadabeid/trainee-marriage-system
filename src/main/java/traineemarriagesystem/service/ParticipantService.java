package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Participant;
import traineemarriagesystem.repository.ParticipantRepository;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;


    public Participant addParticipant(String firstname,String middleName, String lastname,
                                      String username, String email, String address,String age, String gender, String password,
                                      String phoneNumber){
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

        return participantRepository.save(participant);
    }

 //delete by id
    public void deleteParticipantById(Long userID){
        participantRepository.deleteById(userID);
    }

    public Participant getParticipantById(Long userID){
        return (Participant) participantRepository.findById(userID).get();
    }

//update    Participant
 public Participant updateParticipant(Long  userId,String firstName,String middleName,String lastNme,
                                      String username, String email, String address,String age, String gender,
                                      String password, String phoneNumber){

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

     return participantRepository.save(participant);

 }






}
