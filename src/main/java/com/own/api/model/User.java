package com.own.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String avatarImg;

    public User(Long id, String email, String password, String name, UserRole userRole, String avatarImg) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
        this.avatarImg = avatarImg;
    }

    public User() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public User(String email, String password, String name, UserRole userRole, String avatarImg) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
        this.avatarImg = avatarImg;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserRole getAppUserRole() {
        return userRole;
    }

    @Override
    public String toString(){
        return "Id = " + id + "\'" +
                "Name = " + name + "\'" +
                "Email = " + email + "\'" +
                "Role = " + userRole;
    }
}
