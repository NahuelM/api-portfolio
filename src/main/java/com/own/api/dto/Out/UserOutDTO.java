package com.own.api.dto.Out;

public class UserOutDTO {
    private String email;
    private String name;
    private String avatarImgUrl;

    public UserOutDTO() {
    }

    public UserOutDTO(String email, String name, String avatarImgUrl) {
        this.email = email;
        this.name = name;
        this.avatarImgUrl = avatarImgUrl;
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
}
