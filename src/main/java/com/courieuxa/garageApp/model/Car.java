package com.courieuxa.garageApp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(schema = "garageApp", name = "car")
public class Car {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid = UUID.randomUUID();
    private String model;
    private String brand;
    private int year;
    private String color;

    public Car() {
    }

    @JsonCreator
    public Car(String id,
               String model,
               String brand,
               int year,
               String color) {
        super();
        this.uuid = Objects.isNull(id) ? uuid.randomUUID() : uuid.fromString(id);
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID UUID) {
        this.uuid = UUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
