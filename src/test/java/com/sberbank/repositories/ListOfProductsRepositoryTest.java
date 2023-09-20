package com.sberbank.repositories;

import com.sberbank.models.ListOfProducts;
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
class ListOfProductsRepositoryTest {
    @Autowired
    private ListOfProductsRepository listOfProductsRepository;
    private ListOfProducts listOfProducts1;
    private ListOfProducts listOfProducts2;

    @BeforeEach
    public void setUp() {
        listOfProducts1 = new ListOfProducts(null, "Салат");
        listOfProductsRepository.save(listOfProducts1);
        listOfProducts2 = new ListOfProducts(null, "Пирог");
        listOfProductsRepository.save(listOfProducts2);

    }

    @Test
    public void testGetAllListOfProducts() {
        List<ListOfProducts> listOfProductsList = listOfProductsRepository.findAll();
        assertEquals(2, listOfProductsList.size());
        assertEquals(listOfProducts1.getName(), listOfProductsList.get(0).getName());
        assertEquals(listOfProducts2.getName(), listOfProductsList.get(1).getName());
    }

    @Test
    public void testGetListOfProductsById() {
        ListOfProducts listOfProducts = listOfProductsRepository.findById(listOfProducts1.getId()).orElse(null);
        assertEquals(listOfProducts1.getName(), listOfProducts.getName());
    }

    @Test
    public void testCreateListOfProducts() {
        ListOfProducts newListOfProducts = new ListOfProducts(null, "Яблочный пирог");
        ListOfProducts savedListOfProducts = listOfProductsRepository.save(newListOfProducts);
        assertNotNull(savedListOfProducts.getId());
        assertEquals(newListOfProducts.getName(), savedListOfProducts.getName());
    }

    @Test
    public void testUpdateListOfProducts() {
        ListOfProducts listOfProductsToUpdate = listOfProductsRepository.findById(listOfProducts1.getId()).orElse(null);
        listOfProductsToUpdate.setName("Салат Цезарь");
        ListOfProducts updatedListOfProducts = listOfProductsRepository.save(listOfProductsToUpdate);
        assertEquals(listOfProductsToUpdate.getId(), updatedListOfProducts.getId());
        assertEquals(listOfProductsToUpdate.getName(), updatedListOfProducts.getName());
    }

    @Test
    public void testDeleteListOfProducts() {
        listOfProductsRepository.deleteById(listOfProducts1.getId());
        ListOfProducts deletedListOfProducts = listOfProductsRepository.findById(listOfProducts1.getId()).orElse(null);
        assertNull(deletedListOfProducts);
    }
}