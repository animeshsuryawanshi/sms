package com.app.sunbeam.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.sunbeam.entity.Student;
import com.app.sunbeam.repository.StudentRepository;
import com.app.sunbeam.service.studentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service //used to indicate class is a service component and this class is used to encapsulate business logic
public class StudentServiceImpl implements studentService {

	private StudentRepository studentrepository;
	
	 //this is a spring boot annotation used for dependency injection of entity manager
    // it injects entity manager instance
	//entity manager serves as interface to interact with persistent context
	//persistent context is set of managed entity instances that are present in memory
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public StudentServiceImpl(StudentRepository studentrepository) 
	// This is a constructor for the StudentServiceImpl class. It takes a StudentRepository as a parameter 
	//and initializes the studentrepository field with the provided repository. 
	//This is an example of dependency injection, where the dependencies (in this case, the StudentRepository) 
	//are injected into the class rather than being created inside the class.
	{
		super();
		this.studentrepository = studentrepository;
	}


	@Override
	public List<Student> getAllStudents() {
		
		
		
		
		return studentrepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentrepository.save(student);
	}


	@Override
	public Student updateStudent(Student student) {
		
		return studentrepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return studentrepository.findById(id).get();
	}


	@Override
	public void deleteStudentById(Long id) {
		
		 studentrepository.deleteById(id);
	}


	@Override
	public List<Student> findByLastName(String lastname) {
		
		
		return entityManager.createNativeQuery("SELECT * FROM students WHERE last_name = :surname",Student.class )
				.setParameter("surname", lastname)
				.getResultList();
	}

}
