package com.sts.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sts.rest.dao.EmployeeDAO;
import com.sts.rest.model.Employee;
@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	// Get Emp ---
	public Optional<Employee> getEmp(int id) {
		 
		Optional<Employee> findById = this.employeeDAO.findById(id);
		return findById;
	}
	
	// Get AllEmp ---	
	public List<Employee> getAllEmp() {
		 
		List<Employee> findAll = (List<Employee>)this.employeeDAO.findAll();
		return findAll;
	}
	
	// Find AllEmp by Name-----------------
	public List<Employee> findEmpbyname(String empname) {		 
		List<Employee> findByEmpname = this.employeeDAO.findByName(empname);
		return findByEmpname;
	}
	
	// Delete Emp ---	
		public void deleteEmp(Integer id) {			 
			this.employeeDAO.deleteById(id);			
		}
		
		// Update Emp ---	
		public Employee updateEmp(Employee emp) {			 
			Employee empsave = this.employeeDAO.save(emp);
			return empsave;
		}
	
	// Create Emp --
	public Employee createEmp(Employee emp) {
		 
		Employee Employee = this.employeeDAO.save(emp);
		return Employee;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
	
}
