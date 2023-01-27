package com.project.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.model.Category;
import com.project.estoque.model.exception.ResourceNotFoundException;
import com.project.estoque.repository.CategoryRepository;
import com.project.estoque.service.Validations.CategoryValidations;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryValidations validations;

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Long id) {
        Optional<Category> optCategory = repository.findById(id);
        if (optCategory.isEmpty()) {
            throw new ResourceNotFoundException("Categoria com id = " + id + " não encontrada");
        }
        return optCategory;
    }

    public Category register(Category category) {
        validations.nameValidate(category);
        validations.descriptionValidate(category);
        return repository.save(category);
    }

    public Category update(Long id, Category category) {
        validations.nameValidate(category);
        validations.descriptionValidate(category);
        getById(id);
        category.setId(id);
        return repository.save(category);

    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

}