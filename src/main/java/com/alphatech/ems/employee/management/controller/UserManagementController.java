
package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.User;
import com.alphatech.ems.employee.management.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserManagementController {
    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PostMapping("/saveUser") // not using now
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userManagementService.saveUser(user), HttpStatus.OK);
    }
}
