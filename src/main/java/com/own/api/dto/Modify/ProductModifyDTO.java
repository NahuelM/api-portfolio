package com.own.api.dto.Modify;

import java.util.Date;
import java.util.LinkedList;

public class ProductModifyDTO {

    private Long id;
    private String name;
    private String description;
    private CategoryModifyDTO category;
    private LinkedList<String> imagesUrl;
    private Date admissionDate;

    public ProductModifyDTO(String name, String description, CategoryModifyDTO category, LinkedList<String> imagesUrl, Date admissionDate) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.imagesUrl = imagesUrl;
        this.admissionDate = admissionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModifyDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryModifyDTO category) {
        this.category = category;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
