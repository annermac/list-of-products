package com.sberbank.repositories;

import com.sberbank.models.ListOfProducts;
import com.sberbank.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Anna Ermachenkova
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product product1;
    private Product product2;
    private ListOfProducts listOfProducts;
    @BeforeEach
    public void setUp() {
        listOfProducts = new ListOfProducts(null, "Салат");
        product1 = new Product(null, "Помидоры", "1000", "Описание 1", listOfProducts);
        productRepository.save(product1);
        product2 = new Product(null, "Огурцы", "1200", "Описание 2", listOfProducts);
        productRepository.save(product2);

    }
    @Test
    public void testGetAllProducts() {
        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());
        assertEquals("Помидоры", products.get(0).getName());
        assertEquals("Огурцы", products.get(1).getName());
        assertEquals("1000", products.get(0).getWeight());
        assertEquals("1200", products.get(1).getWeight());
        assertEquals("Описание 1", products.get(0).getDescription());
        assertEquals("Описание 2", products.get(1).getDescription());
    }

    @Test
    public void testGetProductById() {
        Product product = productRepository.findById(product1.getId()).orElse(null);
        assertEquals(product1.getName(), product.getName());
        assertEquals(product1.getWeight(), product.getWeight());
        assertEquals(product1.getDescription(), product.getDescription());
    }

    @Test
    public void testCreateProduct(){
        Product newProduct = new Product(null, "Картофель", "1500", "Описание 3", null);
        Product savedProduct = productRepository.save(newProduct);
        assertNotNull(savedProduct.getId());
        assertEquals(newProduct.getName(), savedProduct.getName());
        assertEquals(newProduct.getWeight(), savedProduct.getWeight());
        assertEquals(newProduct.getDescription(), savedProduct.getDescription());
    }

    @Test
    public void testUpdateProduct() {
        Product productToUpdate = productRepository.findById(product1.getId()).orElse(null);
        productToUpdate.setName("Перец");
        productToUpdate.setWeight("500");
        productToUpdate.setDescription("Описание 6");
        Product updatedProduct = productRepository.save(productToUpdate);
        assertEquals(productToUpdate.getId(), updatedProduct.getId());
        assertEquals(productToUpdate.getName(), updatedProduct.getName());
        assertEquals(productToUpdate.getWeight(), updatedProduct.getWeight());
        assertEquals(productToUpdate.getDescription(), updatedProduct.getDescription());
    }
    @Test
    public void testDeleteProduct() {
        productRepository.deleteById(product1.getId());
        Product deletedProduct = productRepository.findById(product1.getId()).orElse(null);
        assertNull(deletedProduct);
    }
}