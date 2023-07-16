package com.alphatech.ems.employee.management.service;


import com.alphatech.ems.employee.management.exception.ResourceNotFoundException;
import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeInfo;
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
    public ResponseEntity<List<EmployeeInfo>> getAllEmployees() {
        List<EmployeeInfo> employeesInfoList = employeeManagementRepository.findAll();
        return new ResponseEntity<>(employeesInfoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeInfo> createEmployee(@RequestBody EmployeeInfo employee) {
        EmployeeInfo createdEmployeeInfo = employeeManagementRepository.save(employee);
        return new ResponseEntity<>(createdEmployeeInfo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeInfo> getEmployeeById(@PathVariable long id) {
        EmployeeInfo employee = employeeManagementRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id: " + id));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // update employee
//    @PutMapping("{id}")
//    public ResponseEntity<EmployeeInfo> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
//        EmployeeInfo updateEmployeeInfo = employeeManagementRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
//        );
//
////        updateEmployee.setFirstName(employeeDetails.getFirstName());
//
//        employeeManagementRepository.save(updateEmployeeInfo);
//
//        return ResponseEntity.ok(updateEmployeeInfo);
//    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        EmployeeInfo employeeInfo = employeeManagementRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
        );

        employeeManagementRepository.delete(employeeInfo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
