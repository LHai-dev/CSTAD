package co.hai.microservices.core.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class FallbackController {
    @GetMapping("/userServiceFallBack")
    public Map<String, String> userServiceFallback(){
        Map<String,String> stringStringMap = new LinkedHashMap<>();
        stringStringMap.put("service","user service is down");
        return stringStringMap;
    }
    @GetMapping("/departmentServiceFallBack")
    public Map<String, String> departmentServiceFallback(){
        Map<String,String> stringStringMap = new LinkedHashMap<>();
        stringStringMap.put("service","department service is down");
        return stringStringMap;
    }
    @GetMapping("/postServiceFallBack")
    public Map<String, String> postServiceFallback(){
        Map<String,String> stringStringMap = new LinkedHashMap<>();
        stringStringMap.put("service","post service is down");
        return stringStringMap;    }
    @GetMapping("/productServiceFallBack")
    public Map<String, String> productServiceFallback(){
        Map<String,String> stringStringMap = new LinkedHashMap<>();
        stringStringMap.put("service","product service is down");
        return stringStringMap;    }
}
