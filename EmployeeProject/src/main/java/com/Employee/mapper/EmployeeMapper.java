package com.Employee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Employee.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO login(HashMap<String, Object> map);

	 List<EmployeeDTO> selectAllEmployee();

	List<EmployeeDTO> employeeLowsalaryList();
		
		


		
}
 
