package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<User,Long> {
   User findByUserName(String userName);
}
