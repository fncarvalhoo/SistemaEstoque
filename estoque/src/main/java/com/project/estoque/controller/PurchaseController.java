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

import com.project.estoque.dto.PurchaseRequestDTO;
import com.project.estoque.dto.PurchaseResponseDTO;
import com.project.estoque.service.PurchaseService;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @GetMapping
    public ResponseEntity<List<PurchaseResponseDTO>> getAll() {
        List<PurchaseResponseDTO> list = service.getAll();
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> getById(@PathVariable Long id) {
        Optional<PurchaseResponseDTO> optPurchase = service.getById(id);
        if (optPurchase.isPresent()) {
            return ResponseEntity.ok(optPurchase.get());

        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PurchaseResponseDTO>> getByStatus(@PathVariable String status) {
        List<PurchaseResponseDTO> optPurchase = service.getByStatus(status);
        return ResponseEntity.ok(optPurchase);

    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> register(@RequestBody PurchaseRequestDTO purchase) {
        PurchaseResponseDTO PurchaseDTO = service.register(purchase);
        return new ResponseEntity<>(PurchaseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> update(@PathVariable Long id,
            @RequestBody PurchaseRequestDTO purchase) {
        return ResponseEntity.ok(service.update(id, purchase));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
