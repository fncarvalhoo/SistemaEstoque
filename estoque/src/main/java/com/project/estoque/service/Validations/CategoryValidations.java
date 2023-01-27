package com.project.estoque.service.Validations;

import com.project.estoque.model.Category;
import com.project.estoque.model.exception.ResourceBadRequestException;

public class CategoryValidations {

    public void nameValidate(Category category) {
        if (category.getName() == null || category.getName().isBlank()) {
            throw new ResourceBadRequestException("O nome deve ser informado");
        } else if (category.getName().length() > 40) {
            throw new ResourceBadRequestException("Tamanho máximo de 40 caracteres no nome");
        }

    }

    public void descriptionValidate(Category category) {
        if (category.getDescription() == null || category.getDescription().isBlank()) {
            throw new ResourceBadRequestException("A descrição deve ser informada");
        } else if (category.getDescription().length() > 200) {
            throw new ResourceBadRequestException("Tamanho máximo de 200 caracteres na descrição");
        }

    }

}
