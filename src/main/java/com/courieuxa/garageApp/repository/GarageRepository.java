package com.courieuxa.garageApp.repository;

import com.courieuxa.garageApp.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GarageRepository extends CrudRepository<Car, UUID> {

}
