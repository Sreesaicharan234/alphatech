package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
}
