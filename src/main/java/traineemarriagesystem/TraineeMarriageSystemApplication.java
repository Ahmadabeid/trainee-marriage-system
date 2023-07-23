package traineemarriagesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import traineemarriagesystem.model.User;
import traineemarriagesystem.repository.UserRepository;

@SpringBootApplication
public class TraineeMarriageSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineeMarriageSystemApplication.class, args);
	}


//	@Bean
	public User insertAdmin(UserRepository userRepository) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User admin = new User();
		admin.setUsername("Ahmad");
		admin.setPassword(passwordEncoder.encode("123"));
		userRepository.save(admin);
		return admin;
	}


}
