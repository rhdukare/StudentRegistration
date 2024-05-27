package com.handling.CollegeRegistractionDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handling.CollegeRegistractionDemo.model.StudentClass;
@Repository
public interface ClassRepository extends JpaRepository<StudentClass, Integer>{

}
