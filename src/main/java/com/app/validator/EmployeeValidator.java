package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Employee;


@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//cast object to Model class
		Employee e=(Employee)target;
		
		//check one by one validations
		/*** ----------Text input  --------**/
		
		if(!Pattern.matches("[A-Z]{2,6}", e.getEmpName())) {
			errors.rejectValue("empName", "enameErr");
		}
		
		/*** radio button validation **/
		if(e.getEmpGen()==null || "".equals(e.getEmpGen())) {
			errors.rejectValue("empGen", "egenErr");
		}
		
		/***drop down validation code**/
		if("".equals(e.getEmpDept())) {
			errors.rejectValue("empDept", "edeptErr");
		}
		
		/**Text area validation**/
		if(e.getEmpAddr()==null || "".equals(e.getEmpAddr().trim()) || e.getEmpAddr().length()<10){
			errors.rejectValue("empAddr","eaddrErr");
		}
		
		/**Check boxes validation*/
		if(e.getEmpLangs()==null || e.getEmpLangs().isEmpty()) {
			errors.rejectValue("empLangs","elangErr");
		}
		
		
	}

}
