package th.com.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.com.dao.StudentDao;
import th.com.entity.Student;

@Service
@Qualifier("Hibernate")
public class StudentService {
	
	@Autowired
	@Qualifier("Hibernate")
	private StudentDao studentdao;
	
	public void insertStudent(Student student){
		studentdao.insertStudent(student);
	}
	
	public void updateStudent(Student student){
		studentdao.updateStudent(student);
	}
	
	public void deleteStudent(Student student){
		studentdao.deleteStudent(student);
	}
	
	public Collection<Student> getAllStudent(){
		return studentdao.getAllStudent();
	}
	
	public Student getStudentById(Integer id){
		return studentdao.getStudentById(id);
	}
	
	public void deleteStudentById(Integer id){
		studentdao.deleteStudentById(id);
	}
}
