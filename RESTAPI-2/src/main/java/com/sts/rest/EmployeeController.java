package com.sts.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.rest.model.Employee;
import com.sts.rest.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Get Employee
	@GetMapping(value = "/getemp/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") int id) {
		try {

			Optional<Employee> emp = employeeService.getEmp(id);
			if (emp.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(emp);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
	}
	
	// Get AllEmployee
	@GetMapping(value = "/getallemp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		try {

			List<Employee> allEmp =(List<Employee>) employeeService.getAllEmp();
			if(allEmp.size()<0)	{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.of(Optional.of(allEmp));
			}
						
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
	}
	
	
	// Find Employee by Name
		@GetMapping(value = "/findempnyname/{name}")
		public ResponseEntity<List<Employee>> findEmpbyname(@PathVariable("name") String name) {
			try {

				List<Employee> emplist = employeeService.findEmpbyname(name);
				if(emplist.size()<0)	{
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				else {
					return ResponseEntity.of(Optional.of(emplist));
				}
							
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

			}
		}

	// Create Employee
	@PostMapping("/crtemp")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {

		try {

			Employee createEmp = employeeService.createEmp(emp);
			return ResponseEntity.status(HttpStatus.OK).body(createEmp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	// Update Employee
	@PutMapping("/updateemp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		try {
			Employee updateEmp = employeeService.updateEmp(emp);
			return ResponseEntity.status(HttpStatus.OK).body(updateEmp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
		try {
			employeeService.deleteEmp(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}	

}
