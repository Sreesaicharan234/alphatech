package com.alphatech.ems.employee.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {



    @GetMapping
    public String getCurrentTime() {
        log.info("Service: Fetching user with id {}"+ LocalDateTime.now());
        return "Hi, Time now: " + LocalDateTime.now();
    }

}
