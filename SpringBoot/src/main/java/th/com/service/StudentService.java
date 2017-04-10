package th.com.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.com.dao.StudentDao;
import th.com.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("Hibernate")
	private StudentDao studentdao;
	
	public void insertStudent(Student student){
		//Do business logic
		System.out.println("got data : " + student.toString());
		studentdao.insertStudent(student);
	}
	
	public void updateStudent(Student student){
		//Do business logic
		System.out.println("got data : " + student.toString());
		studentdao.updateStudent(student);
	}
	
	public void deleteStudent(Student student){
		//Do business logic
		System.out.println("got data : " + student.toString());
		studentdao.deleteStudent(student);
	}
	
	public Collection<Student> getAllStudent(){
		//Do business logic
		return studentdao.getAllStudent();
	}
	
	public Student getStudentById(Integer id){
		//Do business logic
		System.out.println("got data : " + id);
		return studentdao.getStudentById(id);
	}
	
	public void deleteStudentById(Integer id){
		//Do business logic
		System.out.println("got data : " + id);
		studentdao.deleteStudentById(id);
	}
}
