package traineemarriagesystem.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Participant;
import traineemarriagesystem.model.Trainee;
import traineemarriagesystem.model.User;
import traineemarriagesystem.service.ParticipantService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participant")
@CrossOrigin
public class ParticipantController {
    private final ParticipantService participantService;


   @PostMapping("/registerParticipant")
   public ResponseEntity<Participant> registerParticipant(@RequestBody Participant participant){
       Participant newParticipant = participantService.registerParticipant(participant);
       return new ResponseEntity<>(newParticipant,CREATED);
   }

    @PostMapping("/addParticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant){
        Participant newParticipant=participantService.addParticipant(
                participant.getFirstName(),
                participant.getMiddleName(),participant.getLastName(), participant.getUsername(),
                participant.getPassword(),participant.getGender(),participant.getEmail(),
                participant.getPhoneNumber(),participant.getQualification(),participant.getRole(),participant.getStatus());
        return new ResponseEntity<>(newParticipant,CREATED);

    }
    @DeleteMapping("/deleteParticipant/{userID}")
    public void deleteParticipant(Long userID){
        participantService.deleteParticipantById(userID);
    }

    @PutMapping("updateParticipant/{userID}")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant,
                                                         @PathVariable Long userID){
        Participant updateParticipant=participantService.updateParticipant(userID,
                participant.getFirstName(),participant.getMiddleName(),participant.getLastName(),
                participant.getUsername(),participant.getEmail(),
                participant.getGender(), participant.getPassword(), participant.getPhoneNumber(),
                participant.getQualification(),participant.getStatus(),participant.getRole());
        return new ResponseEntity<>(updateParticipant,OK);
    }


    @GetMapping("/getParticipantById/{userID}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long userID){
        Participant participant = participantService.getParticipantById(userID);
        return new ResponseEntity<>(participant, OK);
    }

    @GetMapping("/getParticipants")
    public ResponseEntity<List<User>> getAllParticipant(){
        List<User> newList= participantService.getParticipants();
        return new ResponseEntity<>(newList, OK);
    }


}
