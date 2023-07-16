package com.alphatech.ems.employee.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employment")
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_of_joining")
        private String dateOfJoining;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "salary")
    private double salary;

    @Column(name = "manager_id")
    private String managerId;

}
