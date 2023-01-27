package com.project.estoque.service.Validations;

import com.project.estoque.dto.ProductRequestDTO;
import com.project.estoque.model.exception.ResourceBadRequestException;

public class ProductValidations {

    public void nameValidate(ProductRequestDTO product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ResourceBadRequestException("O nome deve ser informado");
        } else if (product.getName().length() > 20) {
            throw new ResourceBadRequestException("Tamanho máximo de 20 caracteres no nome");
        }
    }

    public void quantityValidate(ProductRequestDTO product) {
        if (product.getQuantity() == null) {
            throw new ResourceBadRequestException("A quantidade de estoque deve ser informada");
        } else if (product.getQuantity() < 0) {
            throw new ResourceBadRequestException("A quantidade de estoque não pode ser negativa");
        }

    }

    public void stdQuantityValidate(ProductRequestDTO product) {
        if (product.getStdQuantity() == null) {
            throw new ResourceBadRequestException("A quantidade de estoque padrão deve ser informada");
        } else if (product.getStdQuantity() < 0) {
            throw new ResourceBadRequestException("A quantidade de estoque padrão não pode ser negativa");
        }

    }

    public void priceValidate(ProductRequestDTO product) {
        if (product.getPrice() == null) {
            throw new ResourceBadRequestException("O preço deve ser informado");
        } else if (product.getPrice() < 0) {
            throw new ResourceBadRequestException("O preço não pode ser negativo");
        }

    }

    public void descriptionValidate(ProductRequestDTO product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ResourceBadRequestException("A descrição deve ser informada");
        } else if (product.getName().length() > 30) {
            throw new ResourceBadRequestException("Tamanho máximo de 30 caracteres na descrição");
        }
    }

}
