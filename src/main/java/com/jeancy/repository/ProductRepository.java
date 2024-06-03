package com.jeancy.repository;

import com.jeancy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jeancy
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
