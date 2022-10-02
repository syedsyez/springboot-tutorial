package com.java.besant.ims.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course_detail database table.
 * 
 */
@Entity
@Table(name="course_detail")
@NamedQuery(name="CourseDetail.findAll", query="SELECT c FROM CourseDetail c")
public class CourseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;

	@Column(name="course_duration")
	private int courseDuration;

	@Column(name="course_name")
	private String courseName;

	//bi-directional many-to-one association to FacultyCours
	@OneToMany(mappedBy="courseDetail")
	private List<FacultyCourse> facultyCourses;

	//bi-directional many-to-one association to StudentCours
	@OneToMany(mappedBy="courseDetail")
	private List<StudentCourse> studentCourses;

	public CourseDetail() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseDuration() {
		return this.courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<FacultyCourse> getFacultyCourses() {
		return this.facultyCourses;
	}

	public void setFacultyCourses(List<FacultyCourse> facultyCourses) {
		this.facultyCourses = facultyCourses;
	}

	public FacultyCourse addFacultyCours(FacultyCourse facultyCours) {
		getFacultyCourses().add(facultyCours);
		facultyCours.setCourseDetail(this);

		return facultyCours;
	}

	public FacultyCourse removeFacultyCours(FacultyCourse facultyCours) {
		getFacultyCourses().remove(facultyCours);
		facultyCours.setCourseDetail(null);

		return facultyCours;
	}

	public List<StudentCourse> getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public StudentCourse addStudentCours(StudentCourse studentCours) {
		getStudentCourses().add(studentCours);
		studentCours.setCourseDetail(this);

		return studentCours;
	}

	public StudentCourse removeStudentCours(StudentCourse studentCours) {
		getStudentCourses().remove(studentCours);
		studentCours.setCourseDetail(null);

		return studentCours;
	}

}