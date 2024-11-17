package com.Auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Auth.Entity.Employee;



	public interface EmployeeNoRepo extends JpaRepository<Employee,Integer>{

	}
	
	
