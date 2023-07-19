package com.alphatech.ems.employee.management.service;
import com.alphatech.ems.employee.management.model.Address;
import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeInfo;
import com.alphatech.ems.employee.management.model.Employment;
import com.alphatech.ems.employee.management.repository.AddressManagementRepository;
import com.alphatech.ems.employee.management.repository.AddressManagementRepository;
import com.alphatech.ems.employee.management.repository.EmployeeInfoManagementRepository;
import com.alphatech.ems.employee.management.repository.EmployeeManagementRepository;
import com.alphatech.ems.employee.management.repository.EmployementRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementService {

    private final EmployeeManagementRepository employeeManagementRepository;

    private final EmployeeInfoManagementRepository employeeInfoManagementRepository;
    private final AddressManagementRepository addressManagement;

    private final EmployementRepository employementRepository;

    public EmployeeManagementService(EmployeeManagementRepository employeeManagementRepository,
                                     EmployeeInfoManagementRepository employeeInfoManagementRepository,
                                     AddressManagementRepository addressManagement,
                                     EmployementRepository employementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
        this.employeeInfoManagementRepository = employeeInfoManagementRepository;
        this.addressManagement = addressManagement;
        this.employementRepository = employementRepository;
    }

    public EmployeeInfo createEmployeeInfo(EmployeeInfo employeeInfoRequest) {
        Employee employee = employeeInfoRequest.getEmployee();
        Address address = employeeInfoRequest.getAddress();
        Employment employment = employeeInfoRequest.getEmployment();

        employee = employeeManagementRepository.save(employee);
        address = addressManagement.save(address);
        employment =  employementRepository.save(employment);

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployee(employee);
        employeeInfo.setAddress(address);
        employeeInfo.setEmployment(employment);
        return employeeInfoManagementRepository.save(employeeInfo);
    }

   public Employee getEmployeeById(Long id) {
        return employeeManagementRepository.getById(id);
    }
    public Employee getEmployeeByFirstName(String firstName) {
        return employeeManagementRepository.findByFirstName(firstName);
    }

}
