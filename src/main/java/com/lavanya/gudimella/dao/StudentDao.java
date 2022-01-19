package com.lavanya.gudimella.dao;

import java.util.ArrayList;    
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lavanya.gudimella.dto.Student;
import com.lavanya.gudimella.hibernate.HibernateConfiguration;

public class StudentDao {
	
	/**
	 * save student using hibernate configuration
	 * @param student
	 */
	public void saveStudent(Student student) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> studentsList = new ArrayList<Student>();
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		studentsList = (ArrayList<Student>) session.createQuery("from Student").list();
		transaction.commit();
		session.close();
		return studentsList;
 	}

	/**
	 * This method is used to get the student from the database
	 * @param id
	 * @return
	 */
	public Student getStudent(int id) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, new Integer(id));
		transaction.commit();
		session.close();
		return student;
	}

	/**
	 * This method is used to update the student record
	 * @param student
	 */
	public void updateStudent(Student student) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
	}

	/**
	 * This method is used to delete the student record 
	 * from the student table
	 * @param student
	 */
	public void deleteStudent(Student student) {
		Session session = HibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
		session.close();
	}
}
