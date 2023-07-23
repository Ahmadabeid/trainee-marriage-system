package traineemarriagesystem.service;
import lombok.Data;
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

@Service
@RequiredArgsConstructor
@Slf4j
//SL4J kwa ajili ya kutuma msj

public class UserDetailServiceimpl implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loginUser = userRepository.findUserByUsername(username);
        if (loginUser == null) {
            log.error("username or password is incorrect");
            throw new RuntimeException("username or password is incorrect");
        }

        log.info("User found by username: " + username);
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        return userPrincipal;
    }
}
