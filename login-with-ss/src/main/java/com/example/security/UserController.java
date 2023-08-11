package com.example.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String home() {
		return "homeview";
	}
	@GetMapping("/login")
	public String showLoginForm(Model model, HttpSession session) {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		String username = authentication.getName();
		session.setAttribute("name",username);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
		}
}
