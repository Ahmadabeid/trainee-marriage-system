package traineemarriagesystem.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.User;
import traineemarriagesystem.model.UserPrincipal;
import traineemarriagesystem.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    public User addUser(String firstName, String middleName,
                        String lastName, String username,
                        String password,
                        String email, String PhoneNumber,
                        String gender) {
        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setPhoneNumber(PhoneNumber);
        user.setGender(gender);

        return userRepository.save(user);
    }


    public void deleteUserById(Long userID){
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

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }


    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

// update User


    public User updateUser(Long userID, String firstName, String middleName,
                           String lastName, String username, String email,
                           String gender, String password, String PhoneNumber){
        User user=getUserById(userID);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setGender(gender);
//        user.setPassword(passwordEncoder.encode(password));
        user.setPhoneNumber(PhoneNumber);
        return userRepository.save(user);
    }


    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}