package com.deep.employeemanager.service;

import com.deep.employeemanager.model.Employee;
import com.deep.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(
            EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    /**
     * Add Exception handling to throw UserNotFoundException if user by
     * id is not found
     */
//    public Employee findEmployeeById(Long id) {
//        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User id by " + id + " was not found"););
//    }
}
