package com.project.estoque.repository;

import org.springframework.stereotype.Repository;

import com.project.estoque.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByQuantity(Integer quantity);

}
