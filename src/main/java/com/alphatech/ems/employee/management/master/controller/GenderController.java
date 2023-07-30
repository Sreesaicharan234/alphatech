package com.alphatech.ems.employee.management.master.controller;

import com.alphatech.ems.employee.management.master.service.GenderService;
import com.alphatech.ems.employee.management.master.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderService.getAllGenders();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable Long id) {
        Gender gender = genderService.getGenderById(id);
        if (gender != null) {
            return new ResponseEntity<>(gender, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Gender> createGender(@RequestBody Gender gender) {
        Gender savedGender = genderService.saveGender(gender);
        return new ResponseEntity<>(savedGender, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender gender) {
        Gender existingGender = genderService.getGenderById(id);
        if (existingGender != null) {
            gender.setId(id);
            Gender updatedGender = genderService.saveGender(gender);
            return new ResponseEntity<>(updatedGender, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        Gender existingGender = genderService.getGenderById(id);
        if (existingGender != null) {
            genderService.deleteGender(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
