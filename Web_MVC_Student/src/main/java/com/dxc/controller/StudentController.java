package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.binding.Student;
import com.dxc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
	/*	Student sObj = new Student();
		//sObj.setName("Pradip");   // To check the functionality of "path" which define in the Form 
		
		//Model obj Sending data controller to view or binding data to form 
		model.addAttribute("student",sObj);                   // why we are sending this empty student bcz to identify the student object in the 
		                                                     // form other it will understand what student in the form (On View)
		
		List<String> listOfCousers = service.getCourses();
		model.addAttribute("courses",listOfCousers); // passing the list of cousers on view to load cousers through service class
		model.addAttribute("prefTimings",service.getTimings());
		*/
		
		//instade of the above code we can write like this
		/*
		 * model.addAttribute("student", new Student());
		 * model.addAttribute("courses",service.getCourses());
		 * model.addAttribute("prefTimings",service.getTimings());
		 */
		
		//insated of above code i have refactore the method  ->Select code ->right click ->Refactor ->Extract Method -> give any name then save
        init(model);
		
		
		return "index";
	}


	private void init(Model model) {
		model.addAttribute("student", new Student());   //using @ModelAttribute we can skip this line  we need to write this annotation save student method like this public String saveStudent(@ModelAttribute ("s") Student s,Model model) { 
		model.addAttribute("courses",service.getCourses());
		model.addAttribute("prefTimings",service.getTimings());
	}
	

	@PostMapping("/save")
	public String saveStudent(Student s,Model model) {
	
	   System.out.println(s);
	   boolean isSave	= service.saveStudent(s);
	   if(isSave) {
		model.addAttribute("msg","Data Saved Saccessfully...!");
	   }
		//insated of dublicate code i have extracted the method bcz in above method and in this method code was same that why 
		init(model);
		return "index";
	}
}
