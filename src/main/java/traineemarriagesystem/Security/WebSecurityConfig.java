package traineemarriagesystem.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/auth/login/**", "user/addUser/**","/trainee/addTrainee/**", "/participant/addParticipant/**","/course/getCourses/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }




}
