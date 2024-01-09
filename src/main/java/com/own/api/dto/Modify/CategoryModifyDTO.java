package com.own.api.dto.Modify;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryModifyDTO {

    @NotNull(message = "The category name can't was null")
    @Size(min = 3, max = 100)
    private String name;
    @NotNull(message = "is necessary the id from category to modify's")
    private Long id;

    public CategoryModifyDTO() {
    }

    public CategoryModifyDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
