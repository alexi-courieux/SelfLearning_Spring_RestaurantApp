package com.courieuxa.restaurantApi.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
public class Product implements Serializable {
    private UUID uuid = UUID.randomUUID();
    private String name;
    private String imagePath;

    private String description;

    private BigDecimal price;

    private String composition;
    private String productType;
    public Product() {
    }
    @JsonCreator
    public Product(String id,
                   String name,
                   String productType,
                   String imagePath,
                   String description,
                   BigDecimal price,
                   String composition) {
        super();
        this.uuid = Objects.isNull(id) ? uuid.randomUUID() : uuid.fromString(id);
        this.name = name;
        this.productType = productType;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
        this.composition = composition;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID UUID) {
        this.uuid = UUID;
    }
    public String getName() {
        return name;
    }
    public void setName(String model) {
        this.name = model;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String brand) {
        this.imagePath = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
