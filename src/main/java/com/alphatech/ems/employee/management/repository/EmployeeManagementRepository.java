package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

  @Query("SELECT e FROM Employee e " +
          "WHERE (:name IS NULL OR e.firstName = :name OR e.lastName = :name) " +
          "AND (:dateOfBirth IS NULL OR e.dateOfBirth = :dateOfBirth) " +
          "AND (:gender IS NULL OR e.gender = :gender) " +
          "AND (:department IS NULL OR e.department = :department) " +
          "AND (:position IS NULL OR e.position = :position)"+
          "AND (:email IS NULL OR e.email = :email)"+
          "AND (:phone IS NULL OR e.phone = :phone)")
  List<Employee> findByAttributes(@Param("name") String name,
                                  @Param("dateOfBirth") String dateOfBirth,
                                  @Param("gender") String gender,
                                  @Param("department") String department,
                                  @Param("position") String position,
                                  @Param("email") String email,
                                  @Param("phone") String phone);




}
