package traineemarriagesystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import traineemarriagesystem.model.User;

import java.util.List;

public interface UserInterface {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User addUser(String firstName, String middleName,
                 String lastName, String username,
                 String password,
                 String email, String PhoneNumber,
                 String gender);

    void deleteUserById(Long userID);

    //    Get users
    List<User> getAllUsers();

    //    Get user by id
    User getUserById(Long userID);

    //    Get user by username
    User getUserByUsername(String username);

    User getUserByEmail(String email);

    User updateUser(Long userID, String firstName, String middleName,
                    String lastName, String username, String email,
                    String gender, String password, String PhoneNumber);
}
