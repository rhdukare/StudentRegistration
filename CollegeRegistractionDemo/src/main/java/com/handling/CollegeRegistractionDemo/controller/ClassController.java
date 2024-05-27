package com.handling.CollegeRegistractionDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handling.CollegeRegistractionDemo.model.StudentClass;
import com.handling.CollegeRegistractionDemo.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@GetMapping
	public ResponseEntity<List<StudentClass>> getAllStudent()
	{
		return classService.getAllDetails();
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<Optional<StudentClass>> getStudent(@PathVariable int sid)
	{
		return classService.getStudent(sid);
	}
	
	@PostMapping
	public void register(@RequestBody StudentClass cl)
	{
		classService.studentRegistration(cl);
	}
	
	@PutMapping
	public void updateStudentsData(@RequestBody StudentClass cl)
	{
		classService.studentupdate(cl);
	}
	
	@DeleteMapping("/{sid}")
	public void deleteStudent(@PathVariable int sid)
	{
		classService.deleteStudentByID(sid);
	}
}
