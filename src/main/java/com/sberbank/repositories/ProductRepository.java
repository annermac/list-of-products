package com.sberbank.repositories;

import com.sberbank.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anna Ermachenkova
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
