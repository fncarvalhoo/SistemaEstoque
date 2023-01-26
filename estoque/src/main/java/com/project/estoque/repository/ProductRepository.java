package com.project.estoque.repository;

import org.springframework.stereotype.Repository;

import com.project.estoque.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
