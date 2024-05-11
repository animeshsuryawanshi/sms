package com.app.sunbeam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.sunbeam.entity.Student;

//JpaRepository interface has simpleJpaRepository class which already has @Repository annotation so we dont need to add this annotation here
public interface StudentRepository extends JpaRepository<Student,Long> {

// jpa repository is part of spring data jpa framework. the spring application which uses jpa for managing,accessing java
// objects and relational db uses jparepo.It provides us with various methods for CRUD operations on data
// it is extension of crud repo.
// jpa repois generic we can provide it Entity and its primary key type
//  in this case Student is entity and Long is type of its primary key	
	
	
	
	
	
}
