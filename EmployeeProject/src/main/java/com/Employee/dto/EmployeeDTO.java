package com.Employee.dto;

import org.apache.ibatis.type.Alias;

@Alias("Employee")
public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private int positionNO;
	private int salary;
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(String eno, String name, String department, int positionNO, int salary) {
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.positionNO = positionNO;
		this.salary = salary;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getPositionNO() {
		return positionNO;
	}
	public void setPositionNO(int positionNO) {
		this.positionNO = positionNO;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", positionNO="
				+ positionNO + ", salary=" + salary + "]";
	}
		
		
	
	
	
	
	
	
}
