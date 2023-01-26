package com.project.estoque.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.model.Product;
import com.project.estoque.repository.ProductRepository;
import com.project.estoque.dto.ProductResponseDTO;
import com.project.estoque.dto.ProductRequestDTO;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<ProductResponseDTO> getAll() {
        List<Product> list = repository.findAll();
        return list.stream().map(product -> mapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProductResponseDTO> getById(Long id) {
        Optional<Product> optProduct = repository.findById(id);
        ProductResponseDTO productDTO = mapper.map(optProduct.get(), ProductResponseDTO.class);
        return Optional.of(productDTO);
    }

    public List<ProductResponseDTO> getByQuantity(Integer quantity) {
        List<Product> list = repository.findByQuantity(quantity);
        return list.stream().map(product -> mapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    public ProductResponseDTO register(ProductRequestDTO product) {
        product.setRegistrationDate(new Date());
        product.setId(null);
        Product productModel = mapper.map(product, Product.class);
        repository.save(productModel);
        ProductResponseDTO productDTO = mapper.map(productModel, ProductResponseDTO.class);
        return productDTO;

    }

    public ProductResponseDTO update(Long id, ProductRequestDTO product) {
        Product productModel = mapper.map(product, Product.class);
        var getProduct = getById(id);
        productModel.setId(id);
        productModel.setRegistrationDate(getProduct.get().getRegistrationDate());
        repository.save(productModel);
        ProductResponseDTO productDTO = mapper.map(productModel, ProductResponseDTO.class);

        return productDTO;
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

}
