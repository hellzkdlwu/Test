package com.Employee.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Employee.dto.EmployeeDTO;
import com.Employee.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	private  EmployeeMapper employeeMapper;

	public EmployeeService(EmployeeMapper employeeMapper) {
		
		this.employeeMapper = employeeMapper;
	}

	public EmployeeDTO login(String eno, String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("eno", eno);
		map.put("name", name);
		
		return employeeMapper.login(map);
	}

	public List<EmployeeDTO> selectAllEmployee() {
		return employeeMapper.selectAllEmployee();
	}

	public List<EmployeeDTO> employeeLowsalaryList() {
		return employeeMapper.employeeLowsalaryList();
	}

	
	
	
}	
