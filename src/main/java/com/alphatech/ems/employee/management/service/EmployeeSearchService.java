/*
/*
* Author Name: K.Sree Sai Charan
* Date: 21-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.service;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.search.dto.EmployeeSearch;
import com.alphatech.ems.employee.management.repository.EmployeeManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSearchService {

    private final EmployeeManagementRepository employeeManagementRepository;

    public EmployeeSearchService(EmployeeManagementRepository employeeManagementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
    }

    public List<Employee> search(EmployeeSearch employeeSearch) {
        String firstName = employeeSearch.getFirstName();
        String lastName = employeeSearch.getLastName();
        String dateOfBirth = employeeSearch.getDateOfBirth();
        String gender = employeeSearch.getGender();
        String department = employeeSearch.getDepartment();
        String position = employeeSearch.getPosition();
        String email = employeeSearch.getEmail();
        String phone = employeeSearch.getPhone();
        return employeeManagementRepository.search(firstName, lastName,
                dateOfBirth, gender, department, position,email,phone);
    }
}
