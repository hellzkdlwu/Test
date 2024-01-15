package com.Employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.quartz.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Employee.dto.EmployeeDTO;
import com.Employee.dto.PositionDTO;

import com.Employee.service.EmployeeService;
import com.Employee.service.positionService;

import batch.SelectEmployeeLowSalary;

import batch.TestCronTrigger;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private EmployeeService employeeService;
	private positionService positionService;
	
	
	
	
	public MainController(EmployeeService employeeService, com.Employee.service.positionService positionService) {
		
		this.employeeService = employeeService;
		this.positionService = positionService;
		TestCronTrigger trigger = new TestCronTrigger("0 0/1 * 1/1 * ? *", (Class<? extends Job>) SelectEmployeeLowSalary.class);
		trigger.triggerJob();
	}

	@RequestMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("/login")
    public String login(String eno, String name, HttpSession session, HttpServletResponse response) throws IOException{
		
		EmployeeDTO employee = employeeService.login(eno, name);
		response.setContentType("text/html;charset=utf-8");
        PrintWriter pw =response.getWriter();
		if(employee == null) {
		pw.write("<script>alert('로그인이 실패했습니다.');location.href='/';</script>");		
		return null;
		}	
		session.setAttribute("employee", employee);
		
		return "redirect:/main"; 
		
	}
	@RequestMapping("/main")
	public ModelAndView main(ModelAndView view) {
		
		List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();	
		List<PositionDTO> positionList = positionService.selectAllPosition();
		
		view.addObject("employeeList", employeeList);
		view.addObject("positionList", positionList);
		view.setViewName("main");
		
		return view;
	}
	
	@RequestMapping("/employee/low-employee-list")
	public ResponseEntity<String> studentLowScoreList(){
		List<EmployeeDTO> list = employeeService.employeeLowsalaryList();
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
