package com.project.estoque.dto;

import java.util.Date;

import com.project.estoque.model.Category;

public class ProductRefinedResponseDTO {

    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private Date registrationDate;

    private Integer stdQuantity;

    public Integer getStdQuantity() {
        return stdQuantity;
    }

    public void setStdQuantity(Integer stdQuantity) {
        this.stdQuantity = stdQuantity;
    }

    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
