package com.dxc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Welcome to my 1st Application");
		mav.setViewName("message"); // to send data on message jsp
		return mav;
	}
	
	@GetMapping("/greet")
	public ModelAndView getGreetMsg(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Good Morning");
		mav.setViewName("message"); // to send data on message jsp
		return mav;
	}

}
