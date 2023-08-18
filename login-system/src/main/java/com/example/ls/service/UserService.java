package com.example.ls.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ls.model.ApplicationUser;
import com.example.ls.model.Role;
import com.example.ls.repository.RoleRepository;
import com.example.ls.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("In user details service");
		
//		if(!username.equals("Ethan")) throw new UsernameNotFoundException("user Name not found");
//		
//		Set<Role> authorities = new HashSet<>();
//		authorities.add(new Role(1,"USER"));
//		
//		return new ApplicationUser(1,"Ethan",passwordEncoder.encode("password"),authorities); 
		
		return userRepository.findByUserName(username).orElseThrow();
	}
	
	public ApplicationUser registerUser(String userName, String password) {
		
		Role userRole = roleRepository.findByAuthority("USER").get();
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(userRole);
		
		return userRepository.save(new ApplicationUser(userName,encoder.encode(password),roles));
	}

}
