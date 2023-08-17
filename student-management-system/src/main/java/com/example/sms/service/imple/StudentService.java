package com.example.sms.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentServiceImpl;

@Service
public class StudentService implements StudentServiceImpl{
	
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}
	
	public Optional<Student> findStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
}
