package edu.shop.java.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/user")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/access_denied", method=RequestMethod.GET)
	public ModelAndView acessDenied(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access_denied");
		return modelAndView;
	}
}
