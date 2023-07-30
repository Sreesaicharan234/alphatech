package com.alphatech.ems.employee.management.master.controller;

import com.alphatech.ems.employee.management.master.dto.MasterDataResponse;
import com.alphatech.ems.employee.management.master.service.EmpStatusService;
import com.alphatech.ems.employee.management.master.service.GenderService;
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

    @Autowired
    public MasterDataController(GenderService genderService, EmpStatusService empStatusService) {
        this.genderService = genderService;
        this.empStatusService = empStatusService;
    }



    @GetMapping
    @ApiOperation(value = "Get all Employee Statuses")
    public ResponseEntity<MasterDataResponse> getAllEmpStatuses() {
        MasterDataResponse masterDataResponse = new MasterDataResponse();
        masterDataResponse.setEmpStatuses(empStatusService.getAllEmpStatuses());
        masterDataResponse.setGenderList(genderService.getAllGenders());
        return ResponseEntity.ok(masterDataResponse);
    }


}
