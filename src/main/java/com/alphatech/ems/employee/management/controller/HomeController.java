package com.alphatech.ems.employee.management.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getCurrentTime() {
        return "Hi, Time now: " + LocalDateTime.now();
    }

}
