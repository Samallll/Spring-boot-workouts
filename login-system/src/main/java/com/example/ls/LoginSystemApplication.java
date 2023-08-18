package com.example.ls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.ls.model.ApplicationUser;
import com.example.ls.model.Role;
import com.example.ls.repository.RoleRepository;
import com.example.ls.repository.UserRepository;

@SpringBootApplication
public class LoginSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSystemApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
		
		return args -> {
			
//			If admin role is present in the table then no need to create a separate admin role. For ddl-auto:update , it is used.
			if(roleRepo.findByAuthority("ADMIN").isPresent()) return;
			
//			Creating a admin role when the application executes if there is no admins.
			Role adminRole = roleRepo.save(new Role("ADMIN"));
			roleRepo.save(new Role("USER"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			
			ApplicationUser admin = new ApplicationUser(1,"admin",encoder.encode("admin"),roles);
			userRepo.save(admin);
			
			};
		}
}