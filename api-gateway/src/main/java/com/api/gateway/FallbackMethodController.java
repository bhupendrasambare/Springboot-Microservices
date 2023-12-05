package com.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/user-service-fallback")
    public String userServiceFallback(){
        return "User Service is down";
    }

    @GetMapping("/department-service-fallback")
    public String departmentServiceFallback(){
        return "Department Service is down";
    }
}
