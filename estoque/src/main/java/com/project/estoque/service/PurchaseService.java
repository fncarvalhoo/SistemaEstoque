package com.project.estoque.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.repository.PurchaseRepository;
import com.project.estoque.dto.PurchaseRequestDTO;
import com.project.estoque.dto.PurchaseResponseDTO;
import com.project.estoque.model.Purchase;
import com.project.estoque.model.exception.ResourceNotFoundException;

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

    public Optional<PurchaseResponseDTO> getById(Long id) {
        Optional<Purchase> optPurchase = repository.findById(id);
        if (optPurchase.isEmpty()) {
            throw new ResourceNotFoundException("Compra com id = " + id + " não encontrada");
        }
        PurchaseResponseDTO dtoPurchase = mapper.map(optPurchase.get(), PurchaseResponseDTO.class);
        return Optional.of(dtoPurchase);

    }

    public List<PurchaseResponseDTO> getByStatus(String status) {
        List<Purchase> list = repository.findByStatus(status);
        List<PurchaseResponseDTO> newList = new ArrayList<PurchaseResponseDTO>();
        for (Purchase purchase : list) {
            newList.add(mapper.map(purchase, PurchaseResponseDTO.class));
        }

        return newList;

    }

    public PurchaseResponseDTO register(PurchaseRequestDTO purchase) {
        purchase.setPurchaseDate(new Date());
        Purchase purchaseModel = mapper.map(purchase, Purchase.class);
        purchaseModel.setId(null);
        repository.save(purchaseModel);
        PurchaseResponseDTO response = mapper.map(purchaseModel, PurchaseResponseDTO.class);

        return response;
    }

    public PurchaseResponseDTO update(Long id, PurchaseRequestDTO purchase) {
        Optional<PurchaseResponseDTO> previousPurchase = getById(id);
        Purchase purchaseModel = mapper.map(purchase, Purchase.class);
        purchaseModel.setId(id);
        purchaseModel.setPurchaseDate(previousPurchase.get().getPurchaseDate());
        repository.save(purchaseModel);

        return mapper.map(purchaseModel, PurchaseResponseDTO.class);
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

}
