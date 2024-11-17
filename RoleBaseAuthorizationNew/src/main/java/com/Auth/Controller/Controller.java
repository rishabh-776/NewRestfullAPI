package com.Auth.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Auth.EmployeeNoRepo;
import com.Auth.Entity.Employee;

@RestController
public class Controller {
	
	
	@Autowired
	EmployeeNoRepo empRepo;
	
	
	@GetMapping("/Employeess")
	public List<Employee> getallemployee()
	{
		return empRepo.findAll();
	}
	
	
	@PostMapping("/Employeess")
	public Employee createEmployee(@RequestBody Employee employee )
	{
		return empRepo.save(employee);
	}
	
	
	
	@PutMapping("/Employeess/{id}")
	public Employee update(@PathVariable int id , @RequestBody Employee employee)
	
	{
		 Employee existing = empRepo.findById(id).get();
		 existing.setName(employee.getName());
		 existing.setId(employee.getId());
		 
		 empRepo.save(existing);
		 
		 return existing;
		 
	}
	
	
	
	@DeleteMapping("/Employeess/{id}")
	
		public Map<String , Boolean > delete(@PathVariable int id)
		{
		Employee existing = empRepo.findById(id).get();
		empRepo.delete(existing);
		
		Map<String , Boolean > response = new HashMap <String, Boolean>();
		response.put("Deleted",Boolean.TRUE );
		
		return response;
		
		}
	
	
	
	

}
