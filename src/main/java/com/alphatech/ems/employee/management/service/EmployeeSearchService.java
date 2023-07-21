/*
/*
* Author Name: K.Sree Sai Charan
* Date: 21-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.service;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeSearch;
import com.alphatech.ems.employee.management.repository.EmployeeManagementRepository;

import java.util.List;

public class EmployeeSearchService {
    private final EmployeeManagementRepository employeeManagementRepository;

    public EmployeeSearchService(EmployeeManagementRepository employeeManagementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
    }

    public List<Employee> searchEmployeeByName(EmployeeSearch employeeSearch) {
        String name = employeeSearch.getName();
        return employeeManagementRepository.findByFirstNameOrLastName(name , name);
    }
    public List<Employee> searchEmployeesByAttributes(EmployeeSearch employeeSearch) {
        String name = employeeSearch.getName();
        String dateOfBirth = employeeSearch.getDateOfBirth();
        String gender = employeeSearch.getGender();
        String department = employeeSearch.getDepartment();
        String position = employeeSearch.getPosition();
        String email = employeeSearch.getEmail();
        String phone = employeeSearch.getPhone();


        return employeeManagementRepository.findByAttributes(name, dateOfBirth, gender, department, position,email,phone);
    }
}
