package com.example.table;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/first")
	public String viewFirstPage(Model model) {
		
		userList list = new userList();
		List<User>usersList = list.printListOfUsers();
		model.addAttribute("users", usersList);
		return "first.html";
	}
	
	@GetMapping("/second")
	public String viewSecondPage(Model model) {
		
		userList list = new userList();
		List<User>usersList = list.printListOfUsers();
		model.addAttribute("users", usersList);
		return "second.html";
	}
	
//	@GetMapping("/third")
//	public String viewThirdPage(Model model) {
//		
//		userList list = new userList();
//		List<User>usersList = list.printListOfUsers();
//		model.addAttribute("users", usersList);
//		System.out.println(usersList.toString());
//		return "third.html";
//	}
}
