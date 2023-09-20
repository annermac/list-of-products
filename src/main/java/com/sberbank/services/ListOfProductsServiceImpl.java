package com.sberbank.services;

import com.sberbank.models.ListOfProducts;
import com.sberbank.repositories.ListOfProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Anna Ermachenkova
 */
@Service
public class ListOfProductsServiceImpl implements ListOfProductsService{

    private final ListOfProductsRepository listOfProductsRepository;

    @Autowired
    public ListOfProductsServiceImpl(ListOfProductsRepository listOfProductsRepository) {
        this.listOfProductsRepository = listOfProductsRepository;
    }

    @Override
    public List<ListOfProducts> getAllListOfProducts() {
        return listOfProductsRepository.findAll();
    }

    @Override
    public ListOfProducts getListOfProducts(Long listOfProductsId) {
        return listOfProductsRepository.findById(listOfProductsId).get();
    }

    @Override
    public ListOfProducts createListOfProducts(ListOfProducts listOfProducts) {
        return listOfProductsRepository.save(listOfProducts);
    }

    @Override
    public ListOfProducts updateListOfProducts(ListOfProducts listOfProducts) {
        return listOfProductsRepository.save(listOfProducts);
    }

    @Override
    public void deleteListOfProducts(Long listOfProductsId) {
        listOfProductsRepository.deleteById(listOfProductsId);
    }
}
