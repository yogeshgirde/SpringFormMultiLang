package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;
import com.app.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeValidator validator;
	
	//1. show form
	@RequestMapping("/")
	public String showRegPage(ModelMap map) {
		//form backing object
		map.addAttribute("employee", new Employee());
		return "EmpReg";
	}

	//2. on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Employee employee,
			Errors errors,
			ModelMap map) 
	{
		String page=null;
		//first call validator
		validator.validate(employee, errors);
		
		//check for errors
		if(errors.hasErrors()) {
			//having errors
			page="EmpReg";
		}else { //no errors
			map.addAttribute("emp", employee);
			page="EmpData";
		}
		
		return page;
	}
	
}
