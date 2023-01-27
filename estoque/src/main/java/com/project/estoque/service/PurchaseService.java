package com.project.estoque.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.repository.PurchaseRepository;
import com.project.estoque.model.Purchase;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<PurchaseResponseDTO> getAll() {
        List<Purchase> list = repository.findAll();
        return list.stream().map(purchase -> mapper.map(purchase, PurchaseResponseDTO.class))
                .collect(Collectors.toList());
    }
}
