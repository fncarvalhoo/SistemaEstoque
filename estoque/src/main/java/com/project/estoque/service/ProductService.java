package com.project.estoque.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estoque.model.Product;
import com.project.estoque.model.exception.ResourceBadRequestException;
import com.project.estoque.model.exception.ResourceNotFoundException;
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
        if (optProduct.isEmpty()) {
            throw new ResourceNotFoundException("Produto com id = " + id + " não encontrado");
        }
        ProductResponseDTO productDTO = mapper.map(optProduct.get(), ProductResponseDTO.class);
        return Optional.of(productDTO);
    }

    public List<ProductResponseDTO> getByQuantity(Integer quantity) {
        List<Product> list = repository.findByQuantity(quantity);
        return list.stream().map(product -> mapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    public ProductResponseDTO register(ProductRequestDTO product) {
        nameValidate(product);
        quantityValidate(product);
        priceValidate(product);
        stdQuantityValidate(product);
        descriptionValidate(product);
        product.setRegistrationDate(new Date());
        product.setId(null);
        Product productModel = mapper.map(product, Product.class);
        repository.save(productModel);
        ProductResponseDTO productDTO = mapper.map(productModel, ProductResponseDTO.class);
        return productDTO;

    }

    public ProductResponseDTO update(Long id, ProductRequestDTO product) {
        nameValidate(product);
        quantityValidate(product);
        priceValidate(product);
        stdQuantityValidate(product);
        descriptionValidate(product);
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

    private void nameValidate(ProductRequestDTO product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ResourceBadRequestException("O nome deve ser informado");
        } else if (product.getName().length() > 20) {
            throw new ResourceBadRequestException("Tamanho máximo de 20 caracteres no nome");
        }
    }

    private void quantityValidate(ProductRequestDTO product) {
        if (product.getQuantity() == null) {
            throw new ResourceBadRequestException("A quantidade de estoque deve ser informada");
        } else if (product.getQuantity() < 0) {
            throw new ResourceBadRequestException("A quantidade de estoque não pode ser negativa");
        }

    }

    private void stdQuantityValidate(ProductRequestDTO product) {
        if (product.getStdQuantity() == null) {
            throw new ResourceBadRequestException("A quantidade de estoque padrão deve ser informada");
        } else if (product.getStdQuantity() < 0) {
            throw new ResourceBadRequestException("A quantidade de estoque padrão não pode ser negativa");
        }

    }

    private void priceValidate(ProductRequestDTO product) {
        if (product.getPrice() == null) {
            throw new ResourceBadRequestException("O preço deve ser informado");
        } else if (product.getPrice() < 0) {
            throw new ResourceBadRequestException("O preço não pode ser negativo");
        }

    }

    private void descriptionValidate(ProductRequestDTO product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ResourceBadRequestException("A descrição deve ser informada");
        } else if (product.getName().length() > 30) {
            throw new ResourceBadRequestException("Tamanho máximo de 30 caracteres na descrição");
        }
    }

}
