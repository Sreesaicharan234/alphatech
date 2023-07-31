package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employee;
import com.alphatech.ems.employee.management.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
  }
