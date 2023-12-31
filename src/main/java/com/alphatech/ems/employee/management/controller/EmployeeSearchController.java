package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.EmployeeInfo;
import com.alphatech.ems.employee.management.search.dto.EmployeeSearch;
import com.alphatech.ems.employee.management.service.EmployeeSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
public class EmployeeSearchController {

    private final EmployeeSearchService employeeSearchService;

    @Autowired
    public EmployeeSearchController(EmployeeSearchService employeeSearchService) {
        this.employeeSearchService = employeeSearchService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<EmployeeInfo>> search(@RequestBody EmployeeSearch employeeSearch) {
        log.info("entered EmployeeSearchController.search()" + employeeSearch);
        List<EmployeeInfo> searchResult = employeeSearchService.searchEmployeeInfo(employeeSearch);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }
}
