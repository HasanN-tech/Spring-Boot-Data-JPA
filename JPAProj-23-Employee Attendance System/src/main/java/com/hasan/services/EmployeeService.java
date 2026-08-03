package com.hasan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasan.entity.Employee;
import com.hasan.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public String addData(Employee b) {
		repo.save(b);
		return "Data added.";
	}

	public String addMultiData(List<Employee> b) {
		repo.saveAll(b);
		return "Multiple Data added.";
	}

	public Employee getData(Long id) {
		return repo.findById(id).get();

	}

	public List<Employee> viewAll() {
		return repo.findAll();
	}

	public String update(Long id, Double sal) {
		if (repo.existsById(id)) {
			Employee p1 = repo.findById(id).get();
			p1.setSalary(sal);
			repo.save(p1);
			return "Record Updated.";
		} else
			return "Record not found.";
	}

	public String deleteRecord(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Record deleted.";
		} else
			return "Record not found.";
	}

}
