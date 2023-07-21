/*
/*
* Author Name: K.Sree Sai Charan
* Date: 21-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearch {
    private String name;

    private String dateOfBirth;

    private String gender;

    private String department;

    private String position;

    private String email;

    private String phone;
}
