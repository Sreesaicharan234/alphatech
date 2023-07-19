/*
/*
* Author Name: K.Sree Sai Charan
* Date: 18-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeInfo;
import com.alphatech.ems.employee.management.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeManagementController {

private  final EmployeeManagementService employeeManagementService;

    @Autowired
    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }
    @PostMapping
    public ResponseEntity<EmployeeInfo> createEmployeeInfo(@RequestBody EmployeeInfo employeeInfo) {
        return new ResponseEntity<>(employeeManagementService.createEmployeeInfo(employeeInfo), HttpStatus.CREATED);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return  new ResponseEntity<>(employeeManagementService.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("firstName/{firstName}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String firstName){
        return  new ResponseEntity<>(employeeManagementService.getEmployeeByFirstName(firstName),HttpStatus.OK);
    }
}
