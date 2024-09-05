package com.org.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.entity.Employee;
import com.org.java.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/welcome")
	public String welcomeTest() {
		return "Hi Welcome to Spring application development Test";	
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	 Employee emp=employeeService.saveEmployeeDetails(employee);
	 return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAll(){
	List<Employee> list=employeeService.findAllEmployeeDetails();
	return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	
		
	}

}
