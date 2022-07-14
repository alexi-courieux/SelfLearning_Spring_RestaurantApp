package com.courieuxa.restaurantApi.mapper;

import com.courieuxa.restaurantApi.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    private static final String SCHEMA = "restaurantApp";
    private static final String TABLE  = "Product";

    public static final String SELECT_SQL = "SELECT uuid, name, productType, imagePath, description, price, composition from " + SCHEMA + "." + TABLE;
    public static final String DELETE_SQL = "DELETE FROM " + SCHEMA + "." + TABLE;

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        String uuid = rs.getString("uuid");
        String name = rs.getString("name");
        String productType = rs.getString("productType");
        String imagePath = rs.getString("imagePath");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        String composition = rs.getString("composition");

        return new Product(uuid, name, productType, imagePath, description, price, composition);
    }
}
