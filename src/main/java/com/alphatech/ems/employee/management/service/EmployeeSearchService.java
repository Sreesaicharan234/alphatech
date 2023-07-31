
package com.alphatech.ems.employee.management.service;

        import com.alphatech.ems.employee.management.model.EmployeeInfo;
        import com.alphatech.ems.employee.management.repository.EmployeeInfoManagementRepository;
        import com.alphatech.ems.employee.management.search.dto.EmployeeSearch;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
@Slf4j
public class EmployeeSearchService {

    private final EmployeeInfoManagementRepository employeeInfoManagementRepository;

    public EmployeeSearchService(EmployeeInfoManagementRepository employeeInfoManagementRepository) {
        this.employeeInfoManagementRepository = employeeInfoManagementRepository;
    }
    public void t() {
        throw new RuntimeException("");
    }

    public List<EmployeeInfo> searchEmployeeInfo(EmployeeSearch employeeSearch) {
        log.info("entered EmployeeSearchService.searchEmployeeInfo()" + employeeSearch);
        String firstName = employeeSearch.getFirstName();
        String lastName = employeeSearch.getLastName();
        String dateOfBirth = employeeSearch.getDateOfBirth();
        String gender = employeeSearch.getGender();
        String department = employeeSearch.getDepartment();
        String position = employeeSearch.getPosition();
        String email = employeeSearch.getEmail();
        String phone = employeeSearch.getPhone();

        return employeeInfoManagementRepository.search(firstName, lastName, dateOfBirth, gender, department, position, email, phone);
    }}