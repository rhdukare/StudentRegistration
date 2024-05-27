package com.handling.CollegeRegistractionDemo.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.handling.CollegeRegistractionDemo.dao.ClassRepository;
import com.handling.CollegeRegistractionDemo.exception.InvalidInputException;
import com.handling.CollegeRegistractionDemo.exception.ResourceNotFoundExpression;
import com.handling.CollegeRegistractionDemo.model.StudentClass;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;
    
	//GET ALL
	public ResponseEntity<List<StudentClass>> getAllDetails() {	
		return   ResponseEntity.ok(classRepository.findAll());
	}
	
	//GET 
	public ResponseEntity<Optional<StudentClass>> getStudent(int sid) {
		return ResponseEntity.ok(classRepository.findById(sid));
	}

	//POST
	public void studentRegistration(StudentClass cl) {
		StudentClass student=cl;
//		student.setDepartment(cl.getDepartment());
//		student.setMail(cl.getMail());
//		student.setName(cl.getName());
//		student.setPhone_no(cl.getPhone_no());
		System.out.println(student.getDepartment()+" "+student.getMail()+" "+student.getName()+" "+student.getPhone_no());
		checkExeption(student);
		
		classRepository.save(cl);
	}

	//PUT
	public void studentupdate(StudentClass cl) {
		if(classRepository.existsById(cl.getSid())) {
			classRepository.save(cl);
		}else {
			System.out.println("No such Registration...!!");
			throw new ResourceNotFoundExpression("Input Record is having wrong ID");
			}	
	}

	//DELETE
	public void deleteStudentByID(int id) {
		StudentClass class1= classRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExpression("No such Record with that ID") );
		
		classRepository.delete(class1);
//		if(classRepository.existsById(id)){
//			
//		}else {
//			System.out.println("No such ID present...!!");
//			throw new ResourceNotFoundExpression("No such Record with that ID");
//		}		
	}
	
	//exception handling
	private void checkExeption(StudentClass student) {
		//name
		if(Pattern.matches("^[a-zA-Z ]+$", student.getName()))
		{
			System.out.println("Name is valid!");
		}else throw new InvalidInputException("Syntex erroe: Plz enter correct Name(don't use special charactor or numbers).");
		//email
		if(Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", student.getMail()))
		{
			System.out.println("Email is valid!");
		}else throw new InvalidInputException("Syntex erroe: Plz enter correct email address.");
		//phone number
		String number=String.valueOf(student.getPhone_no());
		if(Pattern.matches("^[0-9]{10}", number))
		{
			System.out.println("Number is valid!");
		}else throw new InvalidInputException("Syntex erroe: Plz enter 10 digid phone number.");	
	}

}
