

package com.alphatech.ems.employee.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    String userName;

    @Column(name = "password")
    String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_key_employeeInfo_id")
    EmployeeInfo employeeInfo;
}
