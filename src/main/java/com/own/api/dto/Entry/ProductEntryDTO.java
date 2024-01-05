package com.own.api.dto.Entry;

import jakarta.validation.constraints.NotNull;

import java.util.LinkedList;
import java.util.Set;

public class ProductEntryDTO {

    @NotNull(message = ("the product name can't was null"))
    private String name;


    private Double price;

    private String description;

    private Set<CategoryEntryDTO> categories;

    private LinkedList<String> imagesUrl;

    public ProductEntryDTO(String name, Double price, String description, Set<CategoryEntryDTO> categories, LinkedList<String> imagesUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.imagesUrl = imagesUrl;
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
}
