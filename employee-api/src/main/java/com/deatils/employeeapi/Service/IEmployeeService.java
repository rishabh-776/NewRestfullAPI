package com.deatils.employeeapi.Service;

import java.util.List;

import com.deatils.employeeapi.dto.Employee;

public interface IEmployeeService {

	List<Employee> getALLemployee();
    Employee getEmployeeById(int empId);
	
	
}
