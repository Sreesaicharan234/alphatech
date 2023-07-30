package com.alphatech.ems.employee.management.master.service;

import com.alphatech.ems.employee.management.master.model.EmpStatus;
import com.alphatech.ems.employee.management.master.repository.EmpStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpStatusService {

    private final EmpStatusRepository empStatusRepository;

    @Autowired
    public EmpStatusService(EmpStatusRepository empStatusRepository) {
        this.empStatusRepository = empStatusRepository;
    }

    public EmpStatus createEmpStatus(EmpStatus empStatus) {
        return empStatusRepository.save(empStatus);
    }

    public EmpStatus getEmpStatusById(Long id) {
        Optional<EmpStatus> empStatusOptional = empStatusRepository.findById(id);
        return empStatusOptional.orElse(null);
    }

    public List<EmpStatus> getAllEmpStatuses() {
        return empStatusRepository.findAll();
    }

    public EmpStatus updateEmpStatus(Long id, EmpStatus updatedEmpStatus) {
        Optional<EmpStatus> empStatusOptional = empStatusRepository.findById(id);
        if (empStatusOptional.isPresent()) {
            updatedEmpStatus.setId(id); // Make sure the ID is set to the updatedEmpStatus
            return empStatusRepository.save(updatedEmpStatus);
        } else {
            return null;
        }
    }

    public boolean deleteEmpStatus(Long id) {
        Optional<EmpStatus> empStatusOptional = empStatusRepository.findById(id);
        if (empStatusOptional.isPresent()) {
            empStatusRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
