package com.alphatech.ems.employee.management.master.service;

import com.alphatech.ems.employee.management.master.model.Position;
import com.alphatech.ems.employee.management.master.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPositions() { return positionRepository.findAll();}

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}
