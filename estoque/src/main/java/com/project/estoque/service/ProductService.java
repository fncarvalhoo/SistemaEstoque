package com.project.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.model.Product;
import com.project.estoque.repository.ProdutoRepository;

@Service
public class ProductService {

    @Autowired
    private ProdutoRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> getById(Long id) {
        Optional<Product> optProduct = repository.findById(id);
        return optProduct;
    }

    public Product register(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        getById(id);
        product.setId(id);
        return repository.save(product);
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

}
