package com.project.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estoque.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByStatus(String status);

}
