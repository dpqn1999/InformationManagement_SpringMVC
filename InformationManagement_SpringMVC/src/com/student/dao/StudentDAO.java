package com.student.dao;
import java.io.*;
import java.util.*;

import com.student.entity.Student;

public class StudentDAO {

	private String pathStr = "D:\\2019_2020\\Project A\\InformationManagement_SpringMVC\\data";
	private String fileNameByte = "Student_Data_Byte.txt";

	public StudentDAO() {
		this.createFolder();
	}

	public void createFolder() {
		File folder = new File(pathStr);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public void saveListStudentAsByte(List<Student> listStudent) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(listStudent);
			oos.flush();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public List<Student> readListStudentAsByte() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Student> listStudent = new ArrayList<>();
		try {
			fis = new FileInputStream(pathStr + "\\" + fileNameByte);
			ois = new ObjectInputStream(fis);
			listStudent = (ArrayList<Student>) ois.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return listStudent;
	}

}
