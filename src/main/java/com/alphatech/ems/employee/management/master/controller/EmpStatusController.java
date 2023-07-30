package com.alphatech.ems.employee.management.master.controller;

import com.alphatech.ems.employee.management.master.model.EmpStatus;
import com.alphatech.ems.employee.management.master.service.EmpStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empStatus")
@Api(tags = "Employee Status")
public class EmpStatusController {

    private final EmpStatusService empStatusService;

    @Autowired
    public EmpStatusController(EmpStatusService empStatusService) {
        this.empStatusService = empStatusService;
    }

    @PostMapping
    @ApiOperation(value = "Create an Employee Status")
    public ResponseEntity<EmpStatus> createEmpStatus(@RequestBody EmpStatus empStatus) {
        EmpStatus createdEmpStatus = empStatusService.createEmpStatus(empStatus);
        return ResponseEntity.ok(createdEmpStatus);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get an Employee Status by ID")
    public ResponseEntity<EmpStatus> getEmpStatusById(@PathVariable Long id) {
        EmpStatus empStatus = empStatusService.getEmpStatusById(id);
        if (empStatus != null) {
            return ResponseEntity.ok(empStatus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @ApiOperation(value = "Get all Employee Statuses")
    public ResponseEntity<List<EmpStatus>> getAllEmpStatuses() {
        List<EmpStatus> empStatuses = empStatusService.getAllEmpStatuses();
        return ResponseEntity.ok(empStatuses);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an Employee Status by ID")
    public ResponseEntity<EmpStatus> updateEmpStatus(@PathVariable Long id, @RequestBody EmpStatus empStatus) {
        EmpStatus updatedEmpStatus = empStatusService.updateEmpStatus(id, empStatus);
        if (updatedEmpStatus != null) {
            return ResponseEntity.ok(updatedEmpStatus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an Employee Status by ID")
    public ResponseEntity<Void> deleteEmpStatus(@PathVariable Long id) {
        boolean deleted = empStatusService.deleteEmpStatus(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
