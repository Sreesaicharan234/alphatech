package com.alphatech.ems.employee.management.repository;

import com.alphatech.ems.employee.management.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressManagementRepository extends JpaRepository<Address,Long> {

}
