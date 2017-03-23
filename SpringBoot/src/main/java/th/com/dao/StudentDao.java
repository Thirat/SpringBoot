package th.com.dao;


import java.util.Collection;

import th.com.entity.Student;

public interface StudentDao {
	
	Collection<Student> getAllStudent();
	void insertStudent(Student student);
	void deleteStudent(Student student);
	void updateStudent(Student student);
	Student getStudentById(Integer id);
	void deleteStudentById(Integer id);
}
