package com.java.besant.ims.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the faculty_detail database table.
 * 
 */
@Entity
@Table(name="faculty_detail")
@NamedQuery(name="FacultyDetail.findAll", query="SELECT f FROM FacultyDetail f")
public class FacultyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int facultyId;

	@Column(name="facult_name")
	private String facultName;

	@Column(name="phone_number")
	private String phoneNumber;

	//bi-directional many-to-one association to FacultyCours
	@OneToMany(mappedBy="facultyDetail")
	private List<FacultyCourse> facultyCourses;

	public FacultyDetail() {
	}

	public int getFacultyId() {
		return this.facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultName() {
		return this.facultName;
	}

	public void setFacultName(String facultName) {
		this.facultName = facultName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<FacultyCourse> getFacultyCourses() {
		return this.facultyCourses;
	}

	public void setFacultyCourses(List<FacultyCourse> facultyCourses) {
		this.facultyCourses = facultyCourses;
	}

	public FacultyCourse addFacultyCours(FacultyCourse facultyCours) {
		getFacultyCourses().add(facultyCours);
		facultyCours.setFacultyDetail(this);

		return facultyCours;
	}

	public FacultyCourse removeFacultyCours(FacultyCourse facultyCours) {
		getFacultyCourses().remove(facultyCours);
		facultyCours.setFacultyDetail(null);

		return facultyCours;
	}

}