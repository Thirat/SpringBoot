package th.com.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import th.com.entity.Student;
import th.com.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	public void insertStudent(Student student){
		studentService.insertStudent(student);
	}
	
	public void updateStudent(Student student){
		studentService.updateStudent(student);
	}
	
	public void deleteStudent(Student student){
		studentService.deleteStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
}
