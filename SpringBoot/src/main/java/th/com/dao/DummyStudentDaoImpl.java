package th.com.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import th.com.entity.Student;

@Repository
public class DummyStudentDaoImpl implements StudentDao {
	
	private static Map<Integer,Student> studentList;
	
	static {
		studentList = new HashMap<Integer, Student>();
		studentList.put(1, new Student(1,"Thirat",20));
		studentList.put(2, new Student(2,"Ping",25));
		studentList.put(3, new Student(3,"Chin",30));
	}

	public Collection<Student> getAllStudent() {
		return this.studentList.values();
	}

	public void insertStudent(Student student) {
		if(studentList.containsKey(student.getId())){
			System.out.println("Contain Dupplicate Key :" + student.getId());
		}else{
			studentList.put(student.getId(),student);
		}
	}

	public void deleteStudent(Student student) {
		if(studentList.containsKey(student.getId())){
			studentList.remove(student.getId());
		}else{
			System.out.println("Not contain key : " + student.getId());
		}
	}

	public void updateStudent(Student student) {
		if(studentList.containsKey(student.getId())){
			Student s = studentList.get(student.getId());
			s.setName(student.getName());
			s.setAge(student.getAge());
		}else{
			System.out.println("Not contain key : " + student.getId());
		}
	}

}
