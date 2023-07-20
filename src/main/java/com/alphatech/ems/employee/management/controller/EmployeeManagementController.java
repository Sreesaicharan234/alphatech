package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.EmployeeInfo;
import com.alphatech.ems.employee.management.service.EmployeeManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
@Api(value = "Employee Management", tags = "Employee Management")
public class EmployeeManagementController {

    private  final EmployeeManagementService employeeManagementService;

    @Autowired
    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }

    @ApiOperation(value = "Create Employee Information", notes = "Creates a new Employee record.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee Info created successfully."),
            @ApiResponse(code = 400, message = "Bad Request. Invalid input."),
            @ApiResponse(code = 500, message = "Internal server error.")
    })
    @PostMapping
    public ResponseEntity<EmployeeInfo> createEmployeeInfo(@RequestBody EmployeeInfo employeeInfo) {
        return new ResponseEntity<>(employeeManagementService.createEmployeeInfo(employeeInfo), HttpStatus.CREATED);
    }

}
