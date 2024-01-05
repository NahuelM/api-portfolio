package com.own.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Date admissionDate;

    @OneToMany(mappedBy = "Products", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();
    private LinkedList<String> imagesUrl = new LinkedList<>();

    public Product(Long id, String name, Double price, String description, Date admissionDate, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.admissionDate = admissionDate;
        this.categories = categories;
    }

    public Product(String name, Double price, String description, Date admissionDate,  Set<Category> categories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.admissionDate = admissionDate;
        this.categories = categories;
    }

    public Product() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setImagesUrl(LinkedList<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }


    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id =" + id +
                ", name ='" + name + '\'' +
                ", price ='" + price + '\'' +
                ", description ='" + description + '\'' +
                ", admissionDate =" + admissionDate +
                ", images =" + imagesUrl.toArray().toString() +
                '}';
    }
}
