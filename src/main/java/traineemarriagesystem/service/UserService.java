package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(String firstName, String middleName,
                        String lastName, String username,
                        String password, String address,
                        String email, String PhoneNumber,
                        String gender) {
        User user =new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);;
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhoneNumber(PhoneNumber);
        user.setGender(gender);
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


}


