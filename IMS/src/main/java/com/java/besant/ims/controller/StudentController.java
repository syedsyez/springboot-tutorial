package com.java.besant.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.besant.ims.db.model.Students;
import com.java.besant.ims.dto.Studentdto;
import com.java.besant.ims.services.StudentServices;


@RestController
public class StudentController {
	
	@Autowired
	StudentServices studentService;
	
	@GetMapping("/getAllStudents")
	public List<Studentdto> hello(){
		Iterable<Students> slist = studentService.getStudents();
		List<Studentdto> students = new ArrayList<>();
		Studentdto sdto;
		for(Students st:slist) {
			sdto = new Studentdto();
			sdto.setStudentId(st.getStudentId());
			sdto.setStudentName(st.getStudentName());
			sdto.setAge(st.getAge());
			sdto.setPhoneNumber(st.getPhoneNumber());
			sdto.setCity(st.getCity());
			students.add(sdto);
		}
		return students;
		
	}

}
