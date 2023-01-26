package com.project.estoque.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductRequestDTO {

    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private Integer stdQuantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private Date registrationDate;

    private String description;

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

    public Integer getStdQuantity() {
        return stdQuantity;
    }

    public void setStdQuantity(Integer stdQuantity) {
        this.stdQuantity = stdQuantity;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
