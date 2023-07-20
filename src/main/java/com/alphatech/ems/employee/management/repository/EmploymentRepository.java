package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Employment,Long> {
    
}
