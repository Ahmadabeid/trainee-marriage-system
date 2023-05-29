package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Participant;
import traineemarriagesystem.service.ParticipantService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Participant")
public class ParticipantController {
    private final ParticipantService participantService;
    @PostMapping("/addParticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant){
        Participant newParticipant=participantService.addParticipant(
                participant.getFirstName(),
                participant.getMiddleName(),participant.getLastName(), participant.getUsername(),
                participant.getPassword(),participant.getAddress(),participant.getAge(),participant.getGender(),participant.getEmail(),
                participant.getPhoneNumber());
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
                participant.getUsername(),participant.getEmail(), participant.getAddress(),
                participant.getAge(),participant.getGender(), participant.getPassword(), participant.getPhoneNumber());
        return new ResponseEntity<>(updateParticipant,OK);
    }
}
