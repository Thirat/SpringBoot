package th.com.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import th.com.entity.Student;

@Repository
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
		Session session = factory.openSession();
		Transaction tx = null;
		Collection<Student> studentList = null;
		try{
			tx = session.beginTransaction();
			studentList = session.createQuery("FROM student").list();
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return studentList;
		
	}

	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteStudentById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
