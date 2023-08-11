package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {
	
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @GetMapping("/login")
    public String showLoginForm(Model model) {
    	
    	System.out.println(model.toString());
//    	model == {}
    	User newUser = new User();
//    	Creating the User object to bind the data from the form(view) using model object.
        model.addAttribute("user", newUser);
//    	After adding the "user" key to the model ----> 
//    	model == {user=User [username=null, password=null],....,some other built-in values}
        System.out.println(newUser); 
//      User [username=null, password=null]
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(User user,Model model) {
    	
//    	When the form submitted, Spring Boot automatically binds the form field values to the properties of the User object 
//    	based on the th:field attributes in the Thymeleaf template.This happens before coming inside the method.
    	System.out.println(model.toString());
//    	model ----> model == {user=User [username=admin, password=password],....,some other built-in values}
        String username = user.getUsername();
        String password = user.getPassword();
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
        	System.out.println(username);
        	System.out.println(password);
            return "redirect:/home?name=" + username;
        } else {
            model.addAttribute("message", "Incorrect username or password");
            return "login";
        }
    }
    
    @GetMapping("/home")
    public String homePage(String name,Model model) {
    	model.addAttribute("username", name);
    	return "home";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

}
