package com.alphatech.ems.employee.management.service;


import com.alphatech.ems.employee.management.exception.ResourceNotFoundException;
import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.repository.EmployeeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeManagementService {

    private final EmployeeManagementRepository employeeManagementRepository;


    @Autowired
    public EmployeeManagementService(EmployeeManagementRepository employeeRepository) {
        this.employeeManagementRepository = employeeRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {return "Hello";}

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeManagementRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeManagementRepository.save(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeManagementRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id: " + id));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeManagementRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
        );

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        updateEmployee.setEmailId(employeeDetails.getDepartment());
        updateEmployee.setEmailId(employeeDetails.getStatus());

        employeeManagementRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeManagementRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
        );

        employeeManagementRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
