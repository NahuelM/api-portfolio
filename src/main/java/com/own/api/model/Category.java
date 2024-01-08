package com.own.api.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;

    private String name;

    @JoinTable(name = "Products")
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;
    public Category(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Id = " + Id + "\'" +
                "Name = " + name;
    }
}
