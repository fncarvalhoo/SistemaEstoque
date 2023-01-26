package com.project.estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estoque.dto.ProductRequestDTO;
import com.project.estoque.dto.ProductResponseDTO;
import com.project.estoque.model.Product;
import com.project.estoque.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{quantity}")
    public ResponseEntity<List<ProductResponseDTO>> getByQuantity(@PathVariable Integer quantity) {
        List<ProductResponseDTO> optProduct = service.getByQuantity(quantity);
        return ResponseEntity.ok(optProduct);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<ProductResponseDTO>> getById(@PathVariable Long id) {
        Optional<ProductResponseDTO> optProduct = service.getById(id);
        return ResponseEntity.ok(optProduct);

    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> register(@RequestBody ProductRequestDTO product) {
        ProductResponseDTO productDTO = service.register(product);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductRequestDTO product) {
        return ResponseEntity.ok(service.update(id, product));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
