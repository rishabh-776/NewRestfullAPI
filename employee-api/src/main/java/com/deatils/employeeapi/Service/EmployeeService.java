package com.deatils.employeeapi.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deatils.employeeapi.dto.Employee;


@Service
public class EmployeeService implements IEmployeeService{
	
	
	List <Employee> empList=Arrays.asList
			(new Employee(1,"Rishabh","Paymentd"),
            new Employee(2,"Giyan","EDF"),
            new Employee(3,"Suniyo","JHG"));
	

	@Override
	public List<Employee> getALLemployee() {
		// TODO Auto-generated method stub
		return empList;
	}


	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return empList.stream().filter(e -> e.getEmpID() == empId).findFirst().get();
	}
	
	
	
}
