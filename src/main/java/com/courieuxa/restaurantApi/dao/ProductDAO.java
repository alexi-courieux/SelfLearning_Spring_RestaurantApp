package com.courieuxa.restaurantApi.dao;

import com.courieuxa.restaurantApi.mapper.ProductMapper;
import com.courieuxa.restaurantApi.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductDAO extends JdbcDaoSupport {

    DataSource dataSource;
    ProductMapper mapper;
    NamedParameterJdbcTemplate jdbcTemplate;

    public ProductDAO(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        setJdbcTemplate(new JdbcTemplate());
        this.mapper = new ProductMapper();
    }

    public List<Product> getProducts() {
        String sql = ProductMapper.SELECT_SQL;

        return this.jdbcTemplate.query(sql, mapper);
    }

    public Product getProduct(String id) {
        String sql = ProductMapper.SELECT_SQL +
                " WHERE uuid = :id";
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        return this.jdbcTemplate.queryForObject(sql, parameters, mapper);
    }

    public void deleteProduct(String id) {
        String sql = ProductMapper.DELETE_SQL +
                " WHERE uuid = :id";
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        this.jdbcTemplate.update(sql, parameters);
    }

    public void addProduct(Product product) {
        UUID uuid = UUID.randomUUID();
        String sql = " INSERT INTO " + ProductMapper.SCHEMA + "." + ProductMapper.TABLE + " (uuid, name, productType, imagePath, description, price, composition) VALUES" +
                " (:uuid, :name, :productType, :imagePath, :description, :price, :composition)";
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", uuid.toString())
                .addValue("name", product.getName())
                .addValue("productType", product.getProductType())
                .addValue("imagePath", product.getImagePath())
                .addValue("description", product.getDescription())
                .addValue("price", product.getPrice())
                .addValue("composition", product.getComposition());

        this.jdbcTemplate.update(sql, parameters);
    }

    public void updateProduct(Product product) {
        String sql = " UPDATE " + ProductMapper.SCHEMA + "." + ProductMapper.TABLE +
                " SET name = :name," +
                " productType = :productType," +
                " imagePath = :imagePath," +
                " description = :description," +
                " price = :price," +
                " composition = :composition" +
                " WHERE uuid = :uuid";
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", product.getUuid().toString())
                .addValue("name", product.getName())
                .addValue("productType", product.getProductType())
                .addValue("imagePath", product.getImagePath())
                .addValue("description", product.getDescription())
                .addValue("price", product.getPrice())
                .addValue("composition", product.getComposition());

        this.jdbcTemplate.update(sql, parameters);
    }
}
