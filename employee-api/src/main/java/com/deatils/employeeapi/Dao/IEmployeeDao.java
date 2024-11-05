package com.deatils.employeeapi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deatils.employeeapi.dto.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository <Employee , Integer>{

	
	
	
}
