package com.pasteger.uswa.controller;

import com.pasteger.uswa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    private final UserService service;

    public TestController(UserService service) {
        this.service = service;
    }

    @GetMapping("/two")
    public ResponseEntity<?> theRequest(){
        try {
            return ResponseEntity.ok().body("2");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/start")
    public String start(){
        return "start";
    }

    @GetMapping("/generatenewrandomuser")
    public ResponseEntity<?> generateNewRandomUser(){
        try {
            return ResponseEntity.ok().body(service.generateNewRandomUser());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
