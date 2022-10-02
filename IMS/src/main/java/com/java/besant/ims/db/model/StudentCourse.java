package com.java.besant.ims.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_courses database table.
 * 
 */
@Entity
@Table(name="student_courses")
@NamedQuery(name="StudentCours.findAll", query="SELECT s FROM StudentCourse s")
public class StudentCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="fees_paid")
	private int feesPaid;

	//bi-directional many-to-one association to CourseDetail
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseDetail courseDetail;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_id")
	private Students student;

	public StudentCourse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFeesPaid() {
		return this.feesPaid;
	}

	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}

	public CourseDetail getCourseDetail() {
		return this.courseDetail;
	}

	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}

	public Students getStudent() {
		return this.student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

}