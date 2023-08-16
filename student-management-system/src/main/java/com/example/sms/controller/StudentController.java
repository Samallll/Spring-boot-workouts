package com.example.sms.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.imple.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getStudentsList(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students.html";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
//		To hold the data
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);
		return "create_student.html";
	}
	
	@PostMapping("/students/new")
	public String saveStudent(@ModelAttribute("student") Student s) {
		
		studentService.addStudent(s);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		
//		To hold the date of student data needs to be updated
		Optional<Student> newStudent = studentService.findStudentById(id);
		model.addAttribute("student", newStudent);
		return "edit_student.html";
	}
	
	@GetMapping("/students/edit")
	public String editStudent(@ModelAttribute("student") Student s) {
		
		return return "redirect:/students";
	}
}
