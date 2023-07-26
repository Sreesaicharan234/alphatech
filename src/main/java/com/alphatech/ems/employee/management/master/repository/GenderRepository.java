package com.alphatech.ems.employee.management.master.repository;

import com.alphatech.ems.employee.management.model.master.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

}
