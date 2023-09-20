package com.sberbank.services;

import com.sberbank.models.ListOfProducts;

import java.util.List;
/**
 * @author Anna Ermachenkova
 */
public interface ListOfProductsService {
    List<ListOfProducts> getAllListOfProducts();
    ListOfProducts getListOfProducts(Long listOfProductsId);
    ListOfProducts createListOfProducts(ListOfProducts listOfProducts);
    ListOfProducts updateListOfProducts(ListOfProducts listOfProducts);
    void deleteListOfProducts(Long listOfProductsId);
}
