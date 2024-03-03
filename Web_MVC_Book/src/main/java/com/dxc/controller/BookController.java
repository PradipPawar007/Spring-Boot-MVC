package com.dxc.controller;

import com.dxc.entity.*;
import com.dxc.repository.IBookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
	
	private final  IBookRepository repo;

	@Autowired
	public BookController(IBookRepository repo) {
		this.repo = repo;
	}
	/*
	 * http://localhost:8080/book?id=111  - Browser URL
	 */
	/*
	@GetMapping("/book")
    public ModelAndView getBookById(@RequestParam("id") Integer id){ // To Capture the Data from request we are suing @RequestPraram
		 
		ModelAndView mav = new ModelAndView();
		Optional<Book> findById = repo.findById(id);
    	if(findById.isPresent()) {
    		Book bookObj = findById.get();
    		//Sending Data to View
    		mav.addObject("book",bookObj);
    	}	
    	//Setting name of view
		mav.setViewName("index");  
		return mav;	
	}
	*/
	/*
	 *  Above and this method behave similar but in below method we are
	 *  returning view as string parameter Using Model object we are sending data 
	 *  controller to the view in key and Value format
	 */
	@GetMapping("/book")
    public String  getBookById(@RequestParam("id") Integer id, Model model){ 	
		Optional<Book> findById = repo.findById(id);
    	if(findById.isPresent()) {
    		Book bookObj = findById.get();
    		//Sending Data to View in the format of Key and Value
    		model.addAttribute("book", bookObj);
    	}	 
		return "index";	
	}
    
	
	
}
