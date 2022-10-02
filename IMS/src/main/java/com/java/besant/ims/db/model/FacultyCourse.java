package com.java.besant.ims.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the faculty_courses database table.
 * 
 */
@Entity
@Table(name="faculty_courses")
@NamedQuery(name="FacultyCourse.findAll", query="SELECT f FROM FacultyCourse f")
public class FacultyCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="course_month")
	private String courseMonth;

	//bi-directional many-to-one association to CourseDetail
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseDetail courseDetail;

	//bi-directional many-to-one association to FacultyDetail
	@ManyToOne
	@JoinColumn(name="facultyId")
	private FacultyDetail facultyDetail;

	public FacultyCourse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseMonth() {
		return this.courseMonth;
	}

	public void setCourseMonth(String courseMonth) {
		this.courseMonth = courseMonth;
	}

	public CourseDetail getCourseDetail() {
		return this.courseDetail;
	}

	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}

	public FacultyDetail getFacultyDetail() {
		return this.facultyDetail;
	}

	public void setFacultyDetail(FacultyDetail facultyDetail) {
		this.facultyDetail = facultyDetail;
	}

}