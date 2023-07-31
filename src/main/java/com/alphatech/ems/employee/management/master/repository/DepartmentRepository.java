package com.alphatech.ems.employee.management.master.repository;

import com.alphatech.ems.employee.management.master.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}