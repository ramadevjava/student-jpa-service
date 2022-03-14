package com.student.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.bean.Student;
import com.student.demo.dao.StudentRepository;
import com.student.demo.exception.ResourceNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
		
	}
	
	public Student getStudentById(Long id) throws ResourceNotFoundException {
		Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
		return student;
	}
	
	public long saveStudent(Student student) {
		return studentRepository.save(student).getId();
	}
	
	public Long updateStudent(Student student) {
		 Student student1 = studentRepository.getById(student.getId());
		 student1.setStudentName(student.getStudentName());
		 student1.setStudentClass(student.getStudentClass());
		 student1.setJoinDate(student.getJoinDate());
		 
		return studentRepository.save(student1).getId();
	}
	
	public long deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
		return id;
	}

}
