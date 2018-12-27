package com.example.demo.tes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {

    @GetMapping("/")
    public String index() {
        return "Hi from Open Shift";
    }
    
}
