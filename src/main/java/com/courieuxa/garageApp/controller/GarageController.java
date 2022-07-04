package com.courieuxa.garageApp.controller;

import com.courieuxa.garageApp.model.Car;
import com.courieuxa.garageApp.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class GarageController {

    private GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @RequestMapping("/cars")
    public List<Car> getCars() {
        return garageService.getCars();
    }

    @RequestMapping("/cars/{id}")
    public Car getCar(@PathVariable String id) {
        return garageService.getCar(id);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable String id) {
        garageService.deleteCar(id);
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) {
        garageService.addCar(car);
    }

    @PutMapping("/cars")
    public void updateCar(@RequestBody Car car) {
        garageService.updateCar(car);
    }
}
