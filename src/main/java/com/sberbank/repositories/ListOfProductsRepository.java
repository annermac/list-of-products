package com.sberbank.repositories;

import com.sberbank.models.ListOfProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Anna Ermachenkova
 */
@Repository
public interface ListOfProductsRepository extends JpaRepository<ListOfProducts, Long> {
}
