package com.courieuxa.restaurantApi.dao;

import com.courieuxa.restaurantApi.mapper.ProductMapper;
import com.courieuxa.restaurantApi.model.Product;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDAO extends JdbcDaoSupport {

    DataSource dataSource;
    ProductMapper mapper;
    NamedParameterJdbcTemplate jdbcTemplate;

    public ProductDAO(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = new ProductMapper();
    }

    public List<Product> getProducts() {
        String sql = mapper.SELECT_SQL;

        List<Product> products = this.jdbcTemplate.query(sql, mapper);
        return products;
    }

    public Product getProduct(String id) {
        String sql = new StringBuilder()
                .append(mapper.SELECT_SQL)
                .append(" WHERE uuid = ?")
                .toString();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        Product product = this.jdbcTemplate.queryForObject(sql, parameters, mapper);
        return product;
    }

    public void deleteProduct(String id) {
        String sql = new StringBuilder()
                .append(mapper.DELETE_SQL)
                .append(" WHERE uuid = :id")
                .toString();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        this.jdbcTemplate.update(sql, parameters);
    }
}
