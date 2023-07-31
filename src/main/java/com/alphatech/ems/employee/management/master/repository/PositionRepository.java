package com.alphatech.ems.employee.management.master.repository;

import com.alphatech.ems.employee.management.master.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
