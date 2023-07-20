package com.alphatech.ems.employee.management.service;
import com.alphatech.ems.employee.management.model.*;
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
    public EmployeeManagementService(EmployeeManagementRepository employeeManagementRepository, EmployeeInfoManagementRepository employeeInfoManagementRepository, AddressManagementRepository addressManagement, EmployementRepository employementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
        this.employeeInfoManagementRepository = employeeInfoManagementRepository;
        this.addressManagement = addressManagement;


        this.employementRepository = employementRepository;
    }
    public EmployeeInfo createEmployeeInfo(EmployeeInfo employeeInfoRequest) {
        Employee employee = employeeInfoRequest.getEmployee();
        Address address = employeeInfoRequest.getAddress();
        Employment employment = employeeInfoRequest.getEmployment();

        // Create EmployeeInfo
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployee(employee);
        employeeInfo.setAddress(address);
        employeeInfo.setEmployment(employment);

        // Save EmployeeInfo
        return employeeInfoManagementRepository.save(employeeInfo);
    }
    public Employee searchEmployeeByName(EmployeeSearch employeeSearch) {
        String name = employeeSearch.getName();
        return employeeManagementRepository.findByFirstNameOrLastName(name , name);
    }
    public Employee getEmployeeById(Long id) {

        return employeeManagementRepository.getById(id);
    }












//    private final EmployeeManagementRepository employeeManagementRepository;
//
//
//    @Autowired
//    public EmployeeManagementService(EmployeeManagementRepository employeeRepository) {
//        this.employeeManagementRepository = employeeRepository;
//    }
//
//    @GetMapping("/hello")
//    public String sayHello() {return "Hello";}
//
//    @GetMapping
//    public ResponseEntity<List<EmployeeInfo>> getAllEmployees() {
//        List<EmployeeInfo> employeesInfoList = employeeManagementRepository.findAll();
//        return new ResponseEntity<>(employeesInfoList, HttpStatus.OK);
//    }
//
//
//
//    @GetMapping("{id}")
//    public ResponseEntity<EmployeeInfo> getEmployeeById(@PathVariable long id) {
//        EmployeeInfo employee = employeeManagementRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee does not exist with id: " + id));
//
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

    // update employee
//    @PutMapping("{id}")
//    public ResponseEntity<EmployeeInfo> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
//        EmployeeInfo updateEmployeeInfo = employeeManagementRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
//        );
//
//        updateEmployee.setFirstName(employeeDetails.getFirstName());
//
//        employeeManagementRepository.save(updateEmployeeInfo);
//
//        return ResponseEntity.ok(updateEmployeeInfo);
//    }

    // build delete employee REST API
//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
//        EmployeeInfo employeeInfo = employeeManagementRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("Employee does not exist with id: " + id)
//        );
//
//        employeeManagementRepository.delete(employeeInfo);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
