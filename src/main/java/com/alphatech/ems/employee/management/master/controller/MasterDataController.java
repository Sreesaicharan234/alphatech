package com.alphatech.ems.employee.management.master.controller;

import com.alphatech.ems.employee.management.master.dto.MasterDataResponse;
import com.alphatech.ems.employee.management.master.service.DepartmentService;
import com.alphatech.ems.employee.management.master.service.EmpStatusService;
import com.alphatech.ems.employee.management.master.service.GenderService;
import com.alphatech.ems.employee.management.master.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empmaster")
@Api(tags = "Employee Status")
public class MasterDataController {

    private final GenderService genderService;

    private final EmpStatusService empStatusService;

    private final DepartmentService departmentService;

    private final PositionService positionService;

    @Autowired
    public MasterDataController(GenderService genderService, EmpStatusService empStatusService, DepartmentService departmentService, PositionService positionService) {
        this.genderService = genderService;
        this.empStatusService = empStatusService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Employee Statuses")
    public ResponseEntity<MasterDataResponse> getAllEmpStatuses() {
        MasterDataResponse masterDataResponse = new MasterDataResponse();
        masterDataResponse.setEmpStatuses(empStatusService.getAllEmpStatuses());
        masterDataResponse.setGenderList(genderService.getAllGenders());
        masterDataResponse.setDepartments(departmentService.getAllDepartments());
        masterDataResponse.setPositions(positionService.getAllPositions());
        return ResponseEntity.ok(masterDataResponse);
    }


}
