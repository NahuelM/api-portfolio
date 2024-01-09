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
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @Column(name = "admissionDate")
    private Date admissionDate;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();
    @Column(name = "imagesUrls")
    private LinkedList<String> imagesUrl = new LinkedList<>();

    public Product(Long id, String name, Double price, String description, Date admissionDate, LinkedList<String> imagesUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.admissionDate = admissionDate;
        this.imagesUrl = imagesUrl;
    }

    public Product(String name, Double price, String description, Date admissionDate, LinkedList<String> imagesUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.admissionDate = admissionDate;
        this.imagesUrl = imagesUrl;
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

    public LinkedList<String> getImagesUrl() {
        return imagesUrl;
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
