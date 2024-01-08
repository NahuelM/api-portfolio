package com.own.api.dto.Entry;

import com.own.api.model.UserRole;

public class UserEntryDTO {
    private String password;
    private String email;
    private String name;
    private String avatarImgUrl;
    private UserRole role;
    private Long id;

    public UserEntryDTO(String password, String email, String name, String avatarImgUrl, UserRole role, Long id) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.avatarImgUrl = avatarImgUrl;
        this.role = role;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
