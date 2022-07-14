package com.courieuxa.restaurantApi.controller;

import com.courieuxa.restaurantApi.dao.ProductDAO;
import com.courieuxa.restaurantApi.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

    private ProductDAO productDao;

    public ProductController(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productDao.getProduct(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        productDao.deleteProduct(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productDao.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productDao.updateProduct(product);
    }
}
