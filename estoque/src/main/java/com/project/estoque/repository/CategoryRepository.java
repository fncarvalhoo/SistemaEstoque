package com.project.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estoque.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
