package com.project.estoque.service.Validations;

import java.util.Date;

import com.project.estoque.dto.PurchaseRequestDTO;
import com.project.estoque.model.exception.ResourceBadRequestException;

public class PurchaseValidations {

    public void quantityValidate(PurchaseRequestDTO purchase) {
        if (purchase.getQuantity() == null) {
            throw new ResourceBadRequestException("A quantidade deve ser informada");
        } else if (purchase.getQuantity() < 1) {
            throw new ResourceBadRequestException("O valor da quantidade deve ser maior que 0");
        }
    }

    public void arrivalDateValidate(PurchaseRequestDTO purchase) {
        Date date = new Date();
        if (purchase.getArrivalDate() == null) {
            throw new ResourceBadRequestException("A data de chegada deve ser informada");
        } else if (purchase.getArrivalDate().before(date)) {
            throw new ResourceBadRequestException("A data de chegada não pode ser retroativa");
        }

    }

    public void expirationDateValidate(PurchaseRequestDTO purchase) {
        Date date = new Date();
        if (purchase.getExpirationDate() == null) {
            throw new ResourceBadRequestException("A data de validade deve ser informada");
        } else if (purchase.getExpirationDate().before(date)) {
            throw new ResourceBadRequestException("A data de validade não pode ser retroativa");
        }

    }

    public void statusValidate(PurchaseRequestDTO purchase) {
        if (purchase.getStatus() == null || purchase.getStatus().isBlank()) {
            throw new ResourceBadRequestException("O status deve ser informado");
        } else if (purchase.getStatus().length() > 10) {
            throw new ResourceBadRequestException("Tamanho máximo de 10 caracteres no status");
        }
    }

    public void providerValidate(PurchaseRequestDTO purchase) {
        if (purchase.getProvider() == null || purchase.getProvider().isBlank()) {
            throw new ResourceBadRequestException("O fornecedor deve ser informado");
        } else if (purchase.getStatus().length() > 10) {
            throw new ResourceBadRequestException("Tamanho máximo de 20 caracteres no fornecedor");
        }
    }

}
