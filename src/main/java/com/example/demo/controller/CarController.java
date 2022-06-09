package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.payload.CarPayload;
import com.example.demo.payload.Result;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    @PostMapping("/")
    public ResponseEntity<Result> saveCar(@RequestBody CarPayload carPayload){
        Result result=carService.saveCar(carPayload);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> updateCar(@PathVariable("id") Long id,@RequestBody CarPayload carPayload){
        Result result=carService.editCar(id,carPayload);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @GetMapping("/")
    public ResponseEntity<Result> getAll(){
        Result result=carService.getAll();
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> findCar(@PathVariable("id") Long id){
        Result result=carService.findById(id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteCar(@PathVariable("id") Long id){
        Result result=carService.deleteCar(id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }


}
