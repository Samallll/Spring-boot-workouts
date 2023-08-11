package com.example.cards;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/first")
	public String viewFirstPage() {

		return "first";
	}
	
	@GetMapping("/login")
	public String viewLogin() {

		return "login-one";
	}
}	