package com.own.api.dto.Entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

public class ProductEntryDTO {

    @NotNull(message = ("the product name can't was null"))
    private String name;


    private Double price;

    private String description;

    private Set<CategoryEntryDTO> categories;

    private LinkedList<String> imagesUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "the date can't before today")
    @NotNull(message = "admission date can't was null")
    private Date admissionDate;

    public ProductEntryDTO() {
    }

    public ProductEntryDTO(String name, Double price, String description, Set<CategoryEntryDTO> categories, LinkedList<String> imagesUrl, Date admissionDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.imagesUrl = imagesUrl;
        this.admissionDate = admissionDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CategoryEntryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntryDTO> categories) {
        this.categories = categories;
    }

    public LinkedList<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(LinkedList<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
}
