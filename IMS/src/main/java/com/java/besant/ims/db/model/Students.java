package com.java.besant.ims.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
@NamedQuery(name="Students.findAll", query="SELECT s FROM Students s")
public class Students implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private Integer studentId;

	@Column(name="age")
	private int age;

	@Column(name="city")
	private String city;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="student_name")
	private String studentName;

	//bi-directional many-to-one association to StudentCours
	@OneToMany(mappedBy="student")
	private List<StudentCourse> studentCourses;

	public Students() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<StudentCourse> getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public StudentCourse addStudentCours(StudentCourse studentCours) {
		getStudentCourses().add(studentCours);
		studentCours.setStudent(this);

		return studentCours;
	}

	public StudentCourse removeStudentCours(StudentCourse studentCours) {
		getStudentCourses().remove(studentCours);
		studentCours.setStudent(null);

		return studentCours;
	}

}