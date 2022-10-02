package com.java.besant.ims.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.besant.ims.db.model.FacultyDetail;
import com.java.besant.ims.db.model.Students;

@Repository
public interface StudentRepository extends CrudRepository<Students, Long> {
	
	// List<Student> findAll();
	

		

}
