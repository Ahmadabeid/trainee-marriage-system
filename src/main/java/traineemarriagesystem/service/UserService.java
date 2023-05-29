package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User addUser(String firstName, String middleName,
                        String lastName, String username,
                        String password, String address, String age,
                        String email, String PhoneNumber,
                        String gender) {
        User user =new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhoneNumber(PhoneNumber);
        user.setGender(gender);
        user.setAge(age);
        return userRepository.save(user);
    }

    public void deleteUserById( Long userID){
        userRepository.deleteById(userID);
    }
//    Get users
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
//    Get user by id
    public User getUserById(Long userID){
        return userRepository.findById(userID).get();
    }

//    Get user by username
    public UserRepository getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

// update User

    public User updateUser(Long userID,String firstName, String middleName,
                           String lastName, String username,String email,
                           String address,String age, String gender, String password, String PhoneNumber){
        User user=getUserById(userID);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setAddress(address);
        user.setAge(age);
        user.setGender(gender);
        user.setPassword(password);
        user.setPhoneNumber(PhoneNumber);
        return userRepository.save(user);
    }


 }




