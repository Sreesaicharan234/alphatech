/*
/*
* Author Name: K.Sree Sai Charan
* Date: 21-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeSearch;
import com.alphatech.ems.employee.management.service.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeSearchController {


    private  final EmployeeSearchService employeeSearchService;
@Autowired
    public EmployeeSearchController(EmployeeSearchService employeeSearchService) {
        this.employeeSearchService = employeeSearchService;
    }


    @GetMapping("/searchEmployee")
    public ResponseEntity<List<Employee>> searchUsersByName(@RequestBody EmployeeSearch employeeSearch) {
        return new ResponseEntity<>(employeeSearchService.searchEmployeeByName(employeeSearch), HttpStatus.OK);
    }
    @PostMapping("/searchEmployee")
    public ResponseEntity<List<Employee>> searchEmployeesByAttributes(@RequestBody EmployeeSearch employeeSearch) {


        return new ResponseEntity<>(employeeSearchService.searchEmployeesByAttributes(employeeSearch), HttpStatus.OK);
    }
}
