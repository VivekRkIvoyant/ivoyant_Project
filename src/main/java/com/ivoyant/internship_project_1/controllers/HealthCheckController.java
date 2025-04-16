package com.ivoyant.internship_project_1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("200 - OK", HttpStatus.OK);
    }

    @GetMapping("/ok")
    public ResponseEntity<String> endPoint(){
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

}
