package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
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
@RequestMapping("/Trainee")
public class TraineeController {

    private final TraineeService traineeService;

    @PostMapping("/addTrainee")
    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee){
        Trainee newTrainee=traineeService.addTrainee(trainee.getFirstName(),
                trainee.getMiddleName(),trainee.getLastName(), trainee.getUsername(),
                trainee.getPassword(),trainee.getAddress(),trainee.getAge(),trainee.getGender(),trainee.getEmail(),
                trainee.getPhoneNumber());
        return new ResponseEntity<>(newTrainee, CREATED);
    }

    @DeleteMapping("/delete/{traineeId}")
    public void deleteTraineeById(@PathVariable Long userID){
        traineeService.deleteTraineeById(userID);
    }

    @PutMapping("/updateTrainee/{userID}")
    public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee, @PathVariable Long userID){
        Trainee updateTrainee = (Trainee) traineeService.updateTrainee(userID,
                trainee.getFirstName(),trainee.getMiddleName(),
                trainee.getLastName(),trainee.getUsername(),trainee.getEmail(),
                trainee.getAddress(), trainee.getAge(),trainee.getGender(),trainee.getPassword(),trainee.getPhoneNumber()
        );
        return new ResponseEntity<>(updateTrainee,OK);


    }

//    @GetMapping("/getTrainees")
//    public ResponseEntity<List<Trainee>> getAllTrainee(){
//        List<User> newList =traineeService.getTrainees();
//        return new ResponseEntity<>(newList,OK);
//
//    }


// get TraineeById
    @GetMapping("/getTraineeById/{userId}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable Long userID){
        Trainee trainee =traineeService.getTraineeById(userID);
        return new ResponseEntity<>(trainee,OK);
    }


    }
