package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public interface StudentService {
	public Student addStudent(Student student);
	public List<Student> allStudents();
	public Student getStudentbyId(Integer ID);
	public Student updateStudent(Integer ID, Student student);
	public Student delStudent(Integer ID);
	public List<Student> getByCourse(Student student);
}