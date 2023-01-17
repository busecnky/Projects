package com.busecnky.service;

import java.util.List;

import javax.swing.JOptionPane;

import com.busecnky.entity.Contact;
import com.busecnky.entity.Student;
import com.busecnky.repository.StudentDao;

public class StudentService {

	private StudentDao studentDao;
	
	public StudentService() {
		studentDao = new StudentDao();
	}
	
	public void save(Student student) {
		
		if(student.getEmail().contains("@")) {
			if(!(student.getEmail().startsWith("@"))){
				studentDao.save(student);
			}else {
				JOptionPane.showMessageDialog(null, "Email can't start with @ sign.");
			}			
		}else {
			JOptionPane.showMessageDialog(null, "Email should have @ sign.");
		}
		
		
	}

	public List<Student> getAll() {
		return studentDao.findAll();
	}

	
	public Student findByID(long id) {
		
		return studentDao.findById(id);
	}

	public void delete(long id) {
		studentDao.delete(id);
		
	}



	public Student update(long id, String firstname, String lastname, String email, String gender, Contact contact) {
		Student student = findByID(id);
		student.setName(firstname);
		student.setSurname(lastname);
		student.setEmail(email);
		student.setGender(gender);
		student.setContacts(contact);
		studentDao.update(id, student);
		return student;
		
		
//		if(student.getEmail().contains("@")) {
//			if(!(student.getEmail().startsWith("@"))){
//				studentDao.update(id, student);
//				return student;
//			}else {
//				JOptionPane.showMessageDialog(null, "Email can't start with @ sign.");
//			}
//		}else {
//			JOptionPane.showMessageDialog(null, "Email should have @ sign.");
//		}
//		
//		return null;
//		
		
	}

	public List<Student> getByName(String firstname) {
		return studentDao.getByName(firstname);
	}

	public List<Student> getBySurname(String surname) {
		return studentDao.getBySurname(surname);
			
	}

	public List<Student> getByEmail(String email) {
		return studentDao.getByEmail(email);
	}
	
	
}
