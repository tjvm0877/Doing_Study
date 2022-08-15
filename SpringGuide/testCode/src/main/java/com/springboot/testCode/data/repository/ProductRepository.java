package com.springboot.testCode.data.repository;

import com.springboot.testCode.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
