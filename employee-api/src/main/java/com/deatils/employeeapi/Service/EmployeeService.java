package com.deatils.employeeapi.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deatils.employeeapi.Dao.IEmployeeDao;
import com.deatils.employeeapi.dto.Employee;


@Service
public class EmployeeService implements IEmployeeService{
	
	
	List <Employee> empList= new ArrayList<>(Arrays.asList
			(new Employee(1,"Rishabh","Paymentd"),
            new Employee(2,"Giyan","EDF"),
            new Employee(3,"Suniyo","JHG")));
	
	
	@Autowired
	private IEmployeeDao empref;
	

	@Override
	public List<Employee> getALLemployee() {
		// TODO Auto-generated method stub
		//return empList;
		return empref.findAll();
	}


	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		//return empList.stream().filter(e -> e.getEmpID() == empId).findFirst().get();
		return empref.getOne(empId);
	}


	@Override
	public void addEmployee(Employee employee) {
		//empList.add(employee);
		 empref.save(employee);
		
	}


	@Override
	public void updateEmployee(Employee employee, int empId) {
		/*for(int i =0; i < empList.size(); i++) 
		{
			Employee e = empList.get(i);
			if(e.getEmpID()==empId)
			{
				empList.set(i, employee);
			}
		}
		
	}*/
		empref.save(employee);
	}


	@Override
	public void deleteEmployee(int empId) {
		
		//empList.removeIf(e -> e.getEmpID() == empId);
		
		empref.deleteById(empId);
	}
	
	
	
}
