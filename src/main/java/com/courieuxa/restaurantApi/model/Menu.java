package com.courieuxa.restaurantApi.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Menu implements Serializable {
    private UUID uuid = UUID.randomUUID();
    private String name;
    private BigDecimal price;
    private String description;
    private List<Product> products;
    public Menu() {
    }

    @JsonCreator
    public Menu(UUID uuid, String name, BigDecimal price, String description, List<Product> products) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.products = products;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID UUID) {
        this.uuid = UUID;
    }
}
