package th.com.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.com.entity.Student;
import th.com.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public void insertStudent(@RequestBody Student student){
		studentService.insertStudent(student);
	}
	
	@PutMapping
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@DeleteMapping
	public void deleteStudent(@RequestBody Student student){
		studentService.deleteStudent(student);
	}
	
	@GetMapping
	Collection<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") Integer id){
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") Integer id){
		studentService.deleteStudentById(id);
	}
}
