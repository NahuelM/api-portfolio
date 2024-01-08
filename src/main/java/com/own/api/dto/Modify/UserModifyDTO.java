package com.own.api.dto.Modify;

import com.own.api.model.UserRole;

public class UserModifyDTO {

    private Long id;
    private String email;
    private String name;
    private String avatarImgUrl;
    private String password;

    public UserModifyDTO(String email, String name, String avatarImgUrl, String password) {
        this.email = email;
        this.name = name;
        this.avatarImgUrl = avatarImgUrl;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
