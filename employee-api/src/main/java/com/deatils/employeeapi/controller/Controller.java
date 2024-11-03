package com.deatils.employeeapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deatils.employeeapi.Service.IEmployeeService;
import com.deatils.employeeapi.dto.Employee;


@RestController
public class Controller {
	
	@Autowired
	IEmployeeService empserviceref;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "hello employee";
	}

	
	@RequestMapping("/employee")
	public List <Employee> getAllemployees()
	{
		return empserviceref.getALLemployee();
	}
	
	@RequestMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable int empId)
	{
		return empserviceref.getEmployeeById(empId);
	}
	

}
