package com.student.entity;

import java.io.Serializable;

public class Student implements Serializable {

	private String id;
	private String name;
	private String yearOfBirth;
	private String gender;
	private String schoolYear;
	private String major;
	private String phoneNumber;
	private String email;

	public Student(String id, String name, String yearOfBirth, String gender, String schoolYear, String major,
			String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.schoolYear = schoolYear;
		this.major = major;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
