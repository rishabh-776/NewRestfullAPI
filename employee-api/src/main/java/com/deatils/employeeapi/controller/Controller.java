package com.deatils.employeeapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/employees")
	public void addEmployee(@RequestBody Employee employee)
	{
	  empserviceref.addEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/employees/{empId}")
	public void updateEmployee(@RequestBody Employee employee , @PathVariable int empId)
	{
	  empserviceref.updateEmployee(employee , empId);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/employees/{empId}")
	public void deleteEmployee( @PathVariable int empId)
	{
	  empserviceref.deleteEmployee( empId);
	}
	

}
