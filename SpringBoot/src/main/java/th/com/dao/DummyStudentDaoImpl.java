package th.com.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import th.com.entity.Student;

@Repository
//@Qualifier("dummy")
@Primary
public class DummyStudentDaoImpl implements StudentDao {
	
	private static Map<Integer,Student> studentList;
	
	static {
		studentList = new HashMap<Integer, Student>();
		studentList.put(1, new Student(1,"Thirat",20));
		studentList.put(2, new Student(2,"Ping",25));
		studentList.put(3, new Student(3,"Chin",30));
	}

	public Collection<Student> getAllStudent() {
		System.out.println("Call getAllStudent");
		return this.studentList.values();
	}

	public void insertStudent(Student student) {
		System.out.println("Call insertStudent");
		if(studentList.containsKey(student.getId())){
			System.out.println("Contain Dupplicate Key :" + student.getId());
		}else{
			studentList.put(student.getId(),student);
		}
	}

	public void deleteStudent(Student student) {
		System.out.println("Call deleteStudent");
		if(studentList.containsKey(student.getId())){
			studentList.remove(student.getId());
		}else{
			System.out.println("Not contain key : " + student.getId());
		}
	}

	public void updateStudent(Student student) {
		System.out.println("Call updateStudent");
		if(studentList.containsKey(student.getId())){
			Student s = studentList.get(student.getId());
			s.setName(student.getName());
			s.setAge(student.getAge());
		}else{
			System.out.println("Not contain key : " + student.getId());
		}
	}
	
	public Student getStudentById(Integer id){
		System.out.println("Call getStudentById");
		if(studentList.containsKey(id)){
			return studentList.get(id);
		}else{
			System.out.println("Not contain key : " + id);
			return null;
		}
	}
	
	public void deleteStudentById(Integer id){
		System.out.println("Call deleteStudentById");
		if(studentList.containsKey(id)){
			studentList.remove(id);
		}else{
			System.out.println("Not contain key : " + id);
		}
	}

}
