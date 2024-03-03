package com.dxc.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.binding.Student;
import com.dxc.entity.StudentEntity;
import com.dxc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) {
		StudentEntity entity = new StudentEntity();
	    BeanUtils.copyProperties(student, entity);
	    entity.setTimings(Arrays.toString(student.getTimings()));
	    repo.save(entity);
		return true;
	}
	
    public List<String> getCourses(){
		return Arrays.asList("Java","Python","AWS","DevOps","Dotnet");
	}
    
    public List<String> getTimings(){
		return Arrays.asList("Morning","Evening","Afternoon");
	}
}
