package com.sberbank.controllers;

import com.sberbank.models.ListOfProducts;
import com.sberbank.services.ListOfProductsServiceImpl;
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
@RequestMapping("/list_of_product")
@Slf4j
public class ListOfProductsController {
    private final ListOfProductsServiceImpl listOfProductsService;

    @Autowired
    public ListOfProductsController(ListOfProductsServiceImpl listOfProductsService) {
        this.listOfProductsService = listOfProductsService;
    }

    @GetMapping
    public ResponseEntity<List<ListOfProducts>> getAllListOfProducts() {
        log.info("Получаем списки продуктов");
        return new ResponseEntity<>(listOfProductsService.getAllListOfProducts(), HttpStatus.OK);
    }

    @GetMapping("/{listOfProductsId}")
    public ResponseEntity<ListOfProducts> getListOfProducts(@PathVariable Long listOfProductsId) {
        log.info("Получаем список продуктов");
        return new ResponseEntity<>(listOfProductsService.getListOfProducts(listOfProductsId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ListOfProducts> createListOfProducts(@RequestBody ListOfProducts listOfProducts) {
        log.info("Создаем список продуктов");
        return new ResponseEntity<>(listOfProductsService.createListOfProducts(listOfProducts), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ListOfProducts> updateListOfProducts(@RequestBody ListOfProducts listOfProducts) {
        log.info("Обновляем список продуктов");
        return new ResponseEntity<>(listOfProductsService.updateListOfProducts(listOfProducts), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteListOfProducts(String listOfProductsId) {
        log.info("Удаляем список продуктов");
        listOfProductsService.deleteListOfProducts(Long.parseLong(listOfProductsId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
