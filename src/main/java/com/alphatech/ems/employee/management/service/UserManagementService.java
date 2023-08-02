package com.alphatech.ems.employee.management.service;

import com.alphatech.ems.employee.management.exception.ResourceNotFoundException;
import com.alphatech.ems.employee.management.model.User;
import com.alphatech.ems.employee.management.repository.UserManagementRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;


    public User saveUser(User user) {
        byte[] encodedBytes = Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8));
        String encodedPassword = new String(encodedBytes, StandardCharsets.UTF_8);
        User user2 = new User();
        user2.setUserName(user.getUserName());
        user2.setPassword(encodedPassword);
        return userManagementRepository.save(user2);
    }

    public static Map<String, String> generateToken(User user) {

        Map<String,String> result = new HashMap<String,String>();
        user.setPassword("");
        Map<String,Object> userdata = new HashMap<>();
        userdata.put("userName",user.getUserName());
        String jwt = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "mysecretkey")
                .compact();
        result.put("token",jwt);
        result.put("message","User login success");
        result.put("userName",user.getUserName());

        return result;
    }

    public void updatePasswordAndSetFirstLoginToFalse(String userName, String newPassword) {
        User user = userManagementRepository.findByUserName(userName);
        byte[] encodedBytes = Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8));
        String encodedPassword = new String(encodedBytes, StandardCharsets.UTF_8);
        user.setPassword(encodedPassword);
        user.setFirstLogin(false);
        userManagementRepository.save(user);
    }

}
