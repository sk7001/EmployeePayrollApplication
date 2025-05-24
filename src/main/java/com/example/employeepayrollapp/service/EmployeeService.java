package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(EmployeeDTO dto) {
        Employee employee = new Employee(dto.getName(), dto.getSalary());
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found"));
    }

    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee emp = repository.findById(id)
            .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found"));
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    public void deleteEmployee(Long id) {
        Employee emp = repository.findById(id)
            .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found"));
        repository.delete(emp);
    }
}
