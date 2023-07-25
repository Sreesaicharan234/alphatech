package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementRepository extends JpaRepository<User,Long> {
  // User FindByUserName(String userName);

   User findByUserName(String userName);
}
