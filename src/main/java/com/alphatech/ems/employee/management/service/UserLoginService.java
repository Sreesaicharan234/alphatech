/*
/*
* Author Name: K.Sree Sai Charan
* Date: 25-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.service;

import com.alphatech.ems.employee.management.model.User;
import com.alphatech.ems.employee.management.repository.UserManagementRepository;
import com.alphatech.ems.employee.management.userDto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class UserLoginService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    public User loginCheck(UserLoginDto userLoginDto) {
        byte[] encodedBytes = Base64.getEncoder().encode(userLoginDto.getPassword().getBytes(StandardCharsets.UTF_8));
        String encodedPassword = new String(encodedBytes, StandardCharsets.UTF_8);
        User result = userManagementRepository.findByUserName(userLoginDto.getUserName());
        if (result != null && result.getPassword().equals(encodedPassword) ){
            return result;
        } else {
            return null;
        }
    }
}
