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

@Service
public class UserLoginService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    public User loginCheck(UserLoginDto userLoginDto) {
        User result = userManagementRepository.findByUserName(userLoginDto.getUserName());
        if (result != null && result.getPassword().equals(userLoginDto.getPassword())) {
            return result;
        } else {
            return null;
        }
    }
}
