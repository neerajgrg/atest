package com.ng.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.interviews.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
