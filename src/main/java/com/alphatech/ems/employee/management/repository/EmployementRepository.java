package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployementRepository extends JpaRepository<Employment,Long> {
    
}
