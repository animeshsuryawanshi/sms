package com.app.sunbeam.service;

import java.util.List;

import com.app.sunbeam.entity.Student;

public interface studentService {
	
	 List <Student> getAllStudents();
	 
	 Student saveStudent(Student student);
	 
	 Student updateStudent(Student student);
	 
	 Student getStudentById(Long id);
	 
	 void deleteStudentById(Long id);
	 
	 List<Student> findByLastName(String surname);
	 

}
