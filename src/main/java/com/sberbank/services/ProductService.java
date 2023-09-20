package com.sberbank.services;

import com.sberbank.models.Product;

import java.util.List;

/**
 * @author Anna Ermachenkova
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}
