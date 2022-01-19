package com.lavanya.gudimella.service;

import java.util.ArrayList;
import java.util.List;

import com.lavanya.gudimella.dao.StudentDao;
import com.lavanya.gudimella.dto.Student;

public class StudentService {

	/**
	 * add student to databse using hibernate ORM
	 */
	public void addStudent() {
		StudentDao studentDao = new StudentDao();
		 
		Student student1 = new Student("Lavanya",123,"A10");
		Student student2 = new Student("Srujan",234,"A11");
		Student student3 = new Student("Srikanth",567,"A12");
		Student student4 = new Student("Monica",566,"A13");
		Student student5 = new Student("Shilpa",567,"A14");
		Student student6 = new Student("Theja",678,"A15");
		
		//save students
		studentDao.saveStudent(student1);
		studentDao.saveStudent(student2);
		studentDao.saveStudent(student3);
		studentDao.saveStudent(student4);
		studentDao.saveStudent(student5);
		studentDao.saveStudent(student6);
	}
	
	/**
	 * This method is used to get all the student records
	 * from the database
	 * @param student
	 */
	public String getAllStudents() {
		Student student =new Student();
		StudentDao studentDao = new StudentDao();
		List<Student> studentsList = new ArrayList<Student>();
		studentsList = studentDao.getAllStudents();
		for(int i=0;i<studentsList.size();i++) {
			student = studentsList.get(i);
			System.out.println(studentsList.get(i));
		}
		return student.toString();
	}
	
	/**
	 * This method returns student based on student id from database
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent(id);
		return student;
	}
	
	/**
	 * This method is used to get and update the student by student id
	 * @param id
	 */
	public void updateStudent(int id, String address) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent(id);
		student.setAddress(address);
		studentDao.updateStudent(student);
		System.out.println("Student : " +student.getAddress());
	}
	
	/**
	 * This method is used to get and delete the student by student id
	 * @param id
	 */
	public void deleteStudent(int id) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent(id);
		studentDao.deleteStudent(student);
	}
}
