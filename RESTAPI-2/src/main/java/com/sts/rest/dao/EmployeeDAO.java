package com.sts.rest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.sts.rest.model.Employee;

@Component
public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
	public List<Employee> findByName(String name);

}
