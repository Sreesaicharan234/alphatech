package com.alphatech.ems.employee.management.master.service;

import com.alphatech.ems.employee.management.master.repository.GenderRepository;
import com.alphatech.ems.employee.management.master.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    private final GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    public Gender getGenderById(Long id) {
        return genderRepository.findById(id).orElse(null);
    }

    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    public void deleteGender(Long id) {
        genderRepository.deleteById(id);
    }
}
