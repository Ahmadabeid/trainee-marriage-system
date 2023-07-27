package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Trainee;
import traineemarriagesystem.model.User;
import traineemarriagesystem.service.TraineeService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trainee")
@CrossOrigin
public class TraineeController {

    private final TraineeService traineeService;


    @PostMapping("/registerTrainee")
    public ResponseEntity<Trainee> registerTrainee(@RequestBody Trainee trainee){
        Trainee newTrainee=traineeService.registerTrainee(trainee);
        return new ResponseEntity<>(newTrainee, CREATED);
    }

    @PostMapping("/addTrainee")
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee){
        String regNo=traineeService.generateRegistrationNumber();
        trainee.setRegNo(regNo);
        Trainee newTrainee=traineeService.addTrainee(

                trainee.getEmail(),
                trainee.getFirstName(),
                trainee.getGender(),
                trainee.getLastName(),
                trainee.getMiddleName(),
                trainee.getPassword(),
                trainee.getPhoneNumber(),
                trainee.getRole(),
                trainee.getUsername(),
                trainee.getRegNo(),
                trainee.getPLaceOfBirth(),
                trainee.getDateOfBirth(),
                trainee.getNationality(),
                trainee.getDistrict(),
                trainee.getWard(),
                trainee.getEmploymentStatus(),
                trainee.getMaritalStatus(),
                trainee.getDisability(),
                trainee.getDisabilityTitle(),
                trainee.getEducationalStatus());
        return new ResponseEntity<>(newTrainee, CREATED);
    }

    @DeleteMapping("/delete/{traineeId}")
    public void deleteTraineeById(@PathVariable Long userID){
        traineeService.deleteTraineeById(userID);
    }

    @PutMapping("/updateTrainee/{userID}")
    public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee, @PathVariable Long userID){
        Trainee updateTrainee = traineeService.updateTrainee(userID,
                trainee.getFirstName(),trainee.getMiddleName(),trainee.getRole(),
                trainee.getLastName(),trainee.getUsername(),trainee.getEmail(),
                trainee.getGender(),trainee.getPassword(),trainee.getPhoneNumber(),trainee.getRegNo(),trainee.getPLaceOfBirth(),trainee.getDateOfBirth(),
                trainee.getNationality(),trainee.getDistrict(),
                trainee.getWard(), trainee.getEmploymentStatus(),trainee.getMaritalStatus(),
                trainee.getDisability(), trainee.getDisabilityTitle(), trainee.getEducationalStatus());
        return new ResponseEntity<>(updateTrainee,OK);


    }


    // get TraineeById
    @GetMapping("/getTraineeById/{userID}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable Long userID){
        Trainee trainee =traineeService.getTraineeById(userID);
        return new ResponseEntity<>(trainee,OK);
    }

    @GetMapping("/getTrainees")
    public ResponseEntity<List<User>> getAllTrainee(){
        List<User> newList=traineeService.getTrainees();
        return new ResponseEntity<>(newList, OK);

    }

    @GetMapping("/findTraineeByUsername/{username}")
    public ResponseEntity<User> findTraineeByUsername(@PathVariable("username") String username){
        Trainee trainee = (Trainee) traineeService.findTraineeByUsername(username);
        return new ResponseEntity<>(trainee,OK);
    }

    @GetMapping("/findTraineeByEmail/{email}")
    public ResponseEntity<User> findTraineeByEmail(@PathVariable ("email") String email){
        Trainee trainee =(Trainee) traineeService.findTraineeByEmail(email);
        return new ResponseEntity<>(trainee, OK);
    }


    }
