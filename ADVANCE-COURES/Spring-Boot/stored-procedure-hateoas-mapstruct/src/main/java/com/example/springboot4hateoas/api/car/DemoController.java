package com.example.springboot4hateoas.api.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class DemoController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/total-by-model")
    public ResponseEntity<?> getTotalCarsByModel(@RequestParam(name = "model") String model) {
        int totalCount = carRepository.getTotalCarsByModel(model);
        System.out.println(totalCount);
        return ResponseEntity.ok("total "+model+": "+totalCount);
    }

    @GetMapping("/after-year")
    public ResponseEntity<String> findCarsAfterYear(@RequestParam(name = "year") Integer year) {
        try {
            carRepository.findCarsAfterYear(year);
            return ResponseEntity.ok("Procedure executed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}
