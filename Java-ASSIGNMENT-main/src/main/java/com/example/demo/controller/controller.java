package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImp;

@RestController 
@RequestMapping("/api/students")
public class controller {
	@Autowired
	private StudentServiceImp studentServiceImp;
	
	@GetMapping
	public List<Student> Students(){
		List<Student> s= studentServiceImp.allStudents();
		return s;
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student s) {
		return studentServiceImp.addStudent(s);
	}

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return studentServiceImp.getStudentbyId(id);
    }

    @PutMapping("/{id}")
    public Student update(
            @PathVariable Integer id,
            @RequestBody Student student) {

        return studentServiceImp.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Integer id) {
        return studentServiceImp.delStudent(id);
    }

    @GetMapping("/course/{course}")
    public List<Student> getByCourse(@RequestBody Student student) {
        return studentServiceImp.getByCourse(student);
    }
	
}
