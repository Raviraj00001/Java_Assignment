package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service 
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

//	StudentServiceImp(StudentRepository studentRepository) {
//		this.studentRepository=studentRepository;
//	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student s=studentRepository.save(student);
		return s;
	}

	public List<Student> allStudents() {		
		List<Student> li= studentRepository.findAll();
		return li;
	}

	@Override
	public Student getStudentbyId(Integer ID) {
		// TODO Auto-generated method stub
		return studentRepository.findById(ID)
	            .orElseThrow(() -> new RuntimeException("Student not found: " + ID));
		
	}

	@Override
	public Student updateStudent(Integer ID, Student student) {
		// TODO Auto-generated method stub
		Student existing = getStudentbyId(ID);

	    existing.setName(student.getName());
	    existing.setEmail(student.getEmail());
		existing.setAge(student.getAge());

		return studentRepository.save(existing);
	}

	@Override
	public Student delStudent(Integer ID) {
		// TODO Auto-generated method stub
		 Student student = getStudentbyId(ID);

	    studentRepository.delete(student);

	    return student;

	}

	@Override
	public List<Student> getByCourse(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.findByCourse(student.getCourse());
	}

}
