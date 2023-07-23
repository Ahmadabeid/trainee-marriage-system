package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.User;
import traineemarriagesystem.service.UserInterface;
import traineemarriagesystem.service.UserService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;



    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user)

    {
        User newUser = userService.addUser(user.getFirstName(),
                user.getMiddleName(), user.getLastName(), user.getUsername(),
                user.getPassword(), user.getEmail(),
                user.getPhoneNumber(), user.getGender());
        return new ResponseEntity<>(newUser, CREATED);
    }



    @DeleteMapping("/delete/{userID}")
    public void deleteUserById(@PathVariable Long userID ){
        userService.deleteUserById(userID);
    }
//    Get all users
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> newList = userService.getAllUsers();
        return new ResponseEntity<>(newList, OK);
    }
//    get user by id
    @GetMapping("/getUserById{userID}")
    public ResponseEntity<User> getUserById(@PathVariable Long userID){
        User user = userService.getUserById(userID);
        return new ResponseEntity<>(user, OK);
    }
//    Get userByUsername
    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User user= (User) userService.getUserByUsername(username);
        return new ResponseEntity<>(user, OK);
    }

//    Get userByEmail

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user =(User) userService.getUserByEmail(email);
        return new ResponseEntity<>(user, OK);
    }

//update user
   @PutMapping("/updateUser/{userID}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userID){
        User updateUser= userService.updateUser(userID,
                user.getFirstName(),user.getMiddleName(),user.getLastName(),
                user.getUsername(),user.getEmail(),
                user.getGender(),user.getPassword(),user.getPhoneNumber());
        return new ResponseEntity<>(updateUser, OK);
   }
}
