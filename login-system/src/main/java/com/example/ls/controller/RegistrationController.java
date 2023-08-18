package com.example.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ls.model.ApplicationUser;
import com.example.ls.model.RegistrationDTO;
import com.example.ls.service.UserService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ApplicationUser userRegistration(@RequestBody RegistrationDTO body) {
		return userService.registerUser(body.getUserName(), body.getPassword());
	}

}
