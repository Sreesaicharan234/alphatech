package com.alphatech.ems.employee.management.service;
import com.alphatech.ems.employee.management.model.*;
import com.alphatech.ems.employee.management.repository.AddressManagementRepository;
import com.alphatech.ems.employee.management.repository.EmployeeInfoManagementRepository;
import com.alphatech.ems.employee.management.repository.EmployeeManagementRepository;
import com.alphatech.ems.employee.management.repository.EmploymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeManagementService {

    private final EmployeeManagementRepository employeeManagementRepository;
    private final EmployeeInfoManagementRepository employeeInfoManagementRepository;
    private final AddressManagementRepository addressManagement;
    private final EmploymentRepository employementRepository;

    public EmployeeManagementService(EmployeeManagementRepository employeeManagementRepository, EmployeeInfoManagementRepository employeeInfoManagementRepository, AddressManagementRepository addressManagement, EmploymentRepository employementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
        this.employeeInfoManagementRepository = employeeInfoManagementRepository;
        this.addressManagement = addressManagement;
        this.employementRepository = employementRepository;
    }

    public EmployeeInfo createEmployeeInfo(EmployeeInfo employeeInfoRequest) {

        log.info("entered EmployeeManagementService.createEmployeeInfo(); "+employeeInfoRequest);
        Employee employee = employeeInfoRequest.getEmployee();
        Address address = employeeInfoRequest.getAddress();
        Employment employment = employeeInfoRequest.getEmployment();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployee(employee);
        employeeInfo.setAddress(address);
        employeeInfo.setEmployment(employment);
        return employeeInfoManagementRepository.save(employeeInfo);
    }

    //check2
    //check3

}








