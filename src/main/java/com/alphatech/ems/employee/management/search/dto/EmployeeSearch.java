package com.alphatech.ems.employee.management.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearch {

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String department;

    private String position;

    private String email;

    private String phone;
}
