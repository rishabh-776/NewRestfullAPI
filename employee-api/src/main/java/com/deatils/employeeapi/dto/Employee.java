package com.deatils.employeeapi.dto;

public class Employee {

	private int empID;
	private String empName;
	private String deptName;
	
	
	public Employee() {}
	
	public Employee(int empID, String empName, String deptName) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.deptName = deptName;
	}
	
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
