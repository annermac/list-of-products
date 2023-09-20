package com.sberbank.controllers;

import com.sberbank.models.Product;
import com.sberbank.services.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Anna Ermachenkova
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        log.info("Получаем все продукты");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        log.info("Получаем продукт");
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        log.info("Создаем продукт");
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        log.info("Обновляем продукт");
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(String productId) {
        log.info("Удаляем продукт");
        productService.deleteProduct(Long.parseLong(productId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
