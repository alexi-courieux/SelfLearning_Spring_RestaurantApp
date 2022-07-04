package com.courieuxa.garageApp.service;

import com.courieuxa.garageApp.model.Car;
import com.courieuxa.garageApp.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class GarageService {
    private GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        garageRepository.findAll().forEach(car -> {
            cars.add(car);
        });
        return cars;
    }

    public Car getCar(String id) {
        UUID uuid = UUID.fromString(id);
        return garageRepository.findById(uuid).orElse(null);
    }

    public void deleteCar(String id) {
        UUID uuid = UUID.fromString(id);
        garageRepository.deleteById(uuid);
    }

    public void addCar(Car car) {
        garageRepository.save(car);
    }

    public void updateCar(Car car) {
        garageRepository.save(car);
    }
}
