package th.com.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import th.com.entity.Student;

@Repository
@Qualifier("Hibernate")
public class HibernateStudentDaoImpl implements StudentDao{


	private static SessionFactory factory;
	
	static{
	    try{
	    	 factory = new Configuration().configure().buildSessionFactory();
	     }catch (Throwable ex) { 
	    	 System.err.println("Failed to create sessionFactory object." + ex);
	    	 throw new ExceptionInInitializerError(ex); 
	     }
	}
	
	public Collection<Student> getAllStudent() {
		System.out.println("call getAllStudent from hibernate");
		Session session = factory.openSession();
		Transaction tx = null;
		Collection<Student> studentList = null;
		try{
			tx = session.beginTransaction();
			studentList = session.createQuery("from Student").list();
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return studentList;
		
	}

	public void insertStudent(Student student) {
		System.out.println("call insertStudent from hibernate");
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			System.out.print(student.getId());
			Integer studentId = (Integer) session.save(student);
			System.out.println("print sth : " + studentId);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

	public void deleteStudent(Student student) {
		System.out.println("call deleteStudent from hibernate");
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

	public void updateStudent(Student student) {
		System.out.println("call updateStudent from hibernate");
		
	}

	public Student getStudentById(Integer id) {
		System.out.println("call getStudentById from hibernate");
		return null;
	}

	public void deleteStudentById(Integer id) {
		System.out.println("call deleteStudentById from hibernate");
		
	}

}
