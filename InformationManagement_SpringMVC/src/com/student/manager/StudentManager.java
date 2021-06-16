package com.student.manager;

import java.util.ArrayList;
import java.util.List;

import com.student.dao.StudentDAO;
import com.student.entity.Student;

public class StudentManager {

	private StudentDAO myDAO;
	private List<Student> listStudent;

	public StudentManager(List<Student> listStudent) {
		this.listStudent = listStudent;
		myDAO = new StudentDAO();
	}

	public Student getStudentByID(String id) {
		Student result = null;
		for (int i = 0; i < this.listStudent.size(); i++) {
			if (this.listStudent.get(i).getId().equalsIgnoreCase(id)) {
				return listStudent.get(i);
			}
		}
		return result;
	}

	public boolean addStudent(Student student) {
		boolean result = false;
		Student tempStudent = this.getStudentByID(student.getId());
		if (tempStudent == null) {
			this.listStudent.add(student);
			result = true;
		}
		return result;
	}

	public boolean updateStudentInfo(Student student) {
		boolean result = false;
		for (int i = 0; i < this.listStudent.size(); i++) {
			if (this.listStudent.get(i).getId().equalsIgnoreCase(student.getId())) {
				this.listStudent.remove(i);
				this.listStudent.add(i, student);
				result = true;
				break;
			}
		}
		return result;
	}

	public boolean deleteStudentByID(String id) {
		boolean result = false;
		Student student = this.getStudentByID(id);
		if (student != null) {
			this.listStudent.remove(student);
			result = true;
		}
		return result;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public List<Student> searchByID(String id) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if ((listStudent.get(i).getId().toLowerCase()).contains(id.toLowerCase())) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public List<Student> searchByName(String name) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if ((listStudent.get(i).getName().toLowerCase()).contains(name.toLowerCase())) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public List<Student> searchByGender(String gender) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getGender().equals(gender)) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public List<Student> searchBySchoolYear(String schoolYear) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getSchoolYear().equals(schoolYear)) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public List<Student> searchByYearOfBirth(String yearOfBirth) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getYearOfBirth().equals(yearOfBirth)) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public List<Student> searchByMajor(String major) {
		List<Student> sortedList = new ArrayList<>();
		for (int i = 0; i < listStudent.size(); i++) {
			if (listStudent.get(i).getMajor().contains(major)) {
				sortedList.add(listStudent.get(i));
			}
		}
		return sortedList;
	}

	public int saveByteData() {
		this.myDAO.saveListStudentAsByte(listStudent);
		return this.listStudent.size();
	}

	public int readByteData() {
		this.listStudent = this.myDAO.readListStudentAsByte();
		return this.listStudent.size();
	}
}
