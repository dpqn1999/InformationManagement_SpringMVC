package com.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.entity.Student;
import com.student.manager.StudentManager;

@Controller
public class StudentController {

	private StudentManager studentManager;

	public StudentController() {
		super();
		this.studentManager = new StudentManager(new ArrayList<Student>());
	}

	@RequestMapping("/")
	public ModelAndView showListStudent() {
		List<Student> listStudent = studentManager.getListStudent();
		ModelAndView mav = new ModelAndView("StudentList");
		mav.addObject("listStudent", listStudent);
		return mav;
	}

	@RequestMapping("/new")
	public String showNewStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		String[] majors = { "Business Administration", "Information Technology", "Engineering", "Nursing" };
		model.addAttribute("majors", majors);
		return "NewStudentForm";
	}

	@RequestMapping("/edit")
	public String editCustomerForm(@RequestParam String id, Model model) {
		Student student = studentManager.getStudentByID(id);
		model.addAttribute("student", student);
		String[] majors = { "Business Administration", "Information Technology", "Engineering", "Nursing" };
		model.addAttribute("majors", majors);
		return "EditStudentForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAddStudent(@ModelAttribute("student") Student student) {
		studentManager.addStudent(student);
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateStudent(@ModelAttribute("student") Student student) {
		studentManager.updateStudentInfo(student);
		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam String id) {
		studentManager.deleteStudentByID(id);
		return "redirect:/";
	}

	@RequestMapping("/backup")
	public String doBackupData() {
		studentManager.saveByteData();
		return "redirect:/";
	}

	@RequestMapping("/restore")
	public String doRestoreData() {
		studentManager.readByteData();
		return "redirect:/";
	}
}
