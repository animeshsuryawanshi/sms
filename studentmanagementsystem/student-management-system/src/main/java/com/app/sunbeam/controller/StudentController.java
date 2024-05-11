package com.app.sunbeam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.sunbeam.entity.Student;
import com.app.sunbeam.service.studentService;

@Controller
public class StudentController {

 private studentService studentservice;

public StudentController(studentService studentservice) {
	super();
	this.studentservice = studentservice;
}	
	
	
//handler method to handle list of students and return model and view

@GetMapping("/students") //if user puts "/students" in url then this method is invoked i.e. GetMapping annotation
public String listStudents(Model model ) //The Model object is part of the Spring MVC framework and is used to pass data from the controller to the view.
{
	
	model.addAttribute("students", studentservice.getAllStudents());// add attribute named students to model object
                                                                    // values to this attribute are provided by 
	                                                                //studentservice.getAllStudents() this method
	return "students";
	

}



@GetMapping("/students/new")
public String createStudentForm(Model model)
{
	//create student object to hold student form data
	Student student = new Student();
	model.addAttribute("student", student);//this adds data in object student to model attribute "student"
	                                       //this makes student object available to view
	return "create_student";//framework will find create_student view template and render it
	


}

@PostMapping("/students")//this annot maps HTTP post request for "students" url to this method
public String saveStudent(@ModelAttribute("student") Student student)
//this takes parameter Student with annot ModelAttribute so this parameter is automatically populated with form data submit by user

{
	
	studentservice.saveStudent(student);
	
	return "redirect:/students";


}


@GetMapping("/students/edit/{id}")
public String editStudentForm(@PathVariable Long id,Model model)
{
	model.addAttribute("student",studentservice.getStudentById(id));
	
	return "edit_student";
	


}


@PostMapping("/students/{id}")
public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student ,Model model)
{
  // get student from database by id
	Student existingStudent = studentservice.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	//save updated student object
	
	studentservice.updateStudent(existingStudent);
	return "redirect:/students";
	


}

@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable Long id) 
{
	studentservice.deleteStudentById(id);

    return "redirect:/students";
}


@GetMapping("/search")
public String findStudentByLastName(String lastname,Model model)
{
	
Student student = new Student();

model.addAttribute("student", student);

return "find_student";


}



}










