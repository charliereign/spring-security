package com.charliescode.tutspringbootsecurity;

import com.charliescode.tutspringbootsecurity.model.AppUser;
import com.charliescode.tutspringbootsecurity.model.Role;
import com.charliescode.tutspringbootsecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TutSpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutSpringBootSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    CommandLineRunner lineRunner (AppUserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ENGINEER"));
            userService.saveRole(new Role(null,"DEVELOPER"));
            userService.saveRole(new Role(null,"DEVOPS"));
            userService.saveRole(new Role(null,"ARCHITECT"));

            userService.saveUser(new AppUser(null,"Charlie Reign","charlie","password", new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Jelani Khalifa","jelani","password", new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Salamat Irene","irene","password", new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Lisa Aimar","lisa","password", new ArrayList<>()));

            userService.addRoleToUser("charlie", "ENGINEER");
            userService.addRoleToUser("charlie", "ARCHITECT");
            userService.addRoleToUser("jelani", "DEVELOPER");
            userService.addRoleToUser("irene", "DEVOPS");
            userService.addRoleToUser("lisa", "DEVOPS");
        };
    }*/
}
