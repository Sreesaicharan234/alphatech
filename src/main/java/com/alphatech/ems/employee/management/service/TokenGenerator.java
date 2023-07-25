/*
/*
* Author Name: K.Sree Sai Charan
* Date: 25-07-2023
* Created With: IntelliJ IDEA Community Edition
*/

package com.alphatech.ems.employee.management.service;

import com.alphatech.ems.employee.management.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGenerator {

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
}
