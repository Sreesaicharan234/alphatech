package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoManagementRepository extends JpaRepository<EmployeeInfo,Long> {

}
