package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Optional<Employee> empOpt = repository.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            return repository.save(emp);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
