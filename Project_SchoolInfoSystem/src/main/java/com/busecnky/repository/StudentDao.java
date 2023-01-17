package com.busecnky.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Student;


public class StudentDao implements ICrud<Student>{

		@Override
		public void save(Student t) {

			Transaction transaction = null;

			try (Session session = dataBaseConnectionHibernate()) {

				transaction = session.beginTransaction();
				session.save(t);
				transaction.commit();
				session.close();

			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				System.out.println("Saved Error");
			}

		}

		@Override
		public void update(long id, Student t) {
			Session session = null;
			
			try {
				Student student = findById(id);
				if(student != null) {
					student.setId(t.getId());
					student.setName(t.getName());
					student.setSurname(t.getSurname());
					student.setEmail(t.getEmail());
					student.setGender(t.getGender());
					student.setContacts(t.getContacts());
					
					session = dataBaseConnectionHibernate();
					session.getTransaction().begin();
					session.update(student);
					session.getTransaction().commit();
					System.out.println("Student data is added to DB");
				}
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Some problem occured while adding Student to DB");
			}finally {
				session.close();
			}
		}

		@Override
		public void delete(long id) {

			Transaction transaction = null;

			try (Session session = dataBaseConnectionHibernate()) {
				Student student = findById(id);
				if (student != null) {

					transaction = session.beginTransaction();
					session.delete(student);
					transaction.commit();
					System.out.println("Student deleted---> " + student.getName());
				} else {
					System.out.println("Not found Student ID");
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (transaction != null) {
					transaction.rollback();
				}
			}

		}

		@Override
		public List<Student> findAll() {
			
			Session session = dataBaseConnectionHibernate();
	        TypedQuery<Student> userQuery = session.createQuery("from Student", Student.class);
	        List<Student> student = userQuery.getResultList();
	        return student;
		}
		


		@Override
		public Student findById(long id) {

			Session session = dataBaseConnectionHibernate();

			Student student;

			try {
				student = session.find(Student.class, id);
				if (student != null) {
					System.out.println("Student found -->" + student);
					return student;
				} else {
					System.out.println("Please check ID");
				}
			} catch (Exception e) {
				System.out.println("Something wrong");
			} finally {
				session.close();
			}

			return null;
		}

		public List<Student> getByName(String firstname) {
			Transaction transaction = null;
			List<Student> list = null;
			
			try(Session session = dataBaseConnectionHibernate()) {
				
				// start transaction
				transaction = session.beginTransaction();			
				//get  objects
				list = session.createQuery("Select student from Student as student where student.name like '"+firstname+"%'", Student.class).list();    			
				// commit transaction
				transaction.commit();							
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}		
			return list;
			
		}

		public List<Student> getBySurname(String surname) {
			Transaction transaction = null;
			List<Student> list = null;
			
			try(Session session = dataBaseConnectionHibernate()) {
				
				// start transaction
				transaction = session.beginTransaction();			
				//get  objects
				list = session.createQuery("Select student from Student as student where student.surname like '"+surname+"%'", Student.class).list();    			
				// commit transaction
				transaction.commit();							
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}		
			return list;
		}

		public List<Student> getByEmail(String email) {
			Transaction transaction = null;
			List<Student> list = null;
			
			try(Session session = dataBaseConnectionHibernate()) {
				
				// start transaction
				transaction = session.beginTransaction();			
				//get  objects
				list = session.createQuery("Select student from Student as student where student.email like '"+email+"%'", Student.class).list();    			
				// commit transaction
				transaction.commit();							
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}		
			return list;
		}

	

}
