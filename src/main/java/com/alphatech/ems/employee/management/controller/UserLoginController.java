
package com.alphatech.ems.employee.management.controller;

import com.alphatech.ems.employee.management.model.User;
import com.alphatech.ems.employee.management.service.TokenGenerator;
import com.alphatech.ems.employee.management.service.UserLoginService;
import com.alphatech.ems.employee.management.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginController {
    private final UserLoginService userLoginService;
    private final TokenGenerator tokenGenerator; // Initialize the TokenGenerator

    private final UserManagementService userManagementService;

    public UserLoginController(UserLoginService userLoginService, TokenGenerator tokenGenerator, UserManagementService userManagementService) {
        this.userLoginService = userLoginService;
        this.tokenGenerator = tokenGenerator; // Initialize the TokenGenerator
        this.userManagementService = userManagementService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){

        User result=userLoginService.loginCheck(user);

        if(result!=null){
            return new ResponseEntity<>(tokenGenerator.generateToken(result), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
        }
    }
}
