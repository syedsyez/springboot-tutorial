package com.java.besant.ims.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.besant.ims.db.StudentRepository;
import com.java.besant.ims.db.model.Students;

@Service
public class StudentServices {

	@Resource
	StudentRepository studentRepository;

	public Iterable<Students> getStudents() {

		return studentRepository.findAll();
	}

}
