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

  @Query("SELECT e FROM Employee e " +
          "WHERE (:firstName IS NULL OR e.firstName = :firstName OR e.lastName = :lastName) " +
          "AND (:dateOfBirth IS NULL OR e.dateOfBirth = :dateOfBirth) " +
          "AND (:gender IS NULL OR e.gender = :gender) " +
          "AND (:department IS NULL OR e.department = :department) " +
          "AND (:position IS NULL OR e.position = :position)"+
          "AND (:email IS NULL OR e.email = :email)"+
          "AND (:phone IS NULL OR e.phone = :phone)")
  List<EmployeeInfo> search(@Param("firstName") String firstName,
                            @Param("lastName") String lastName,
                            @Param("dateOfBirth") String dateOfBirth,
                            @Param("gender") String gender,
                            @Param("department") String department,
                            @Param("position") String position,
                            @Param("email") String email,
                            @Param("phone") String phone);




}
