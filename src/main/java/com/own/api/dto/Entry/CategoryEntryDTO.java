package com.own.api.dto.Entry;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryEntryDTO {
    @NotNull(message = "The category name can't was null")
    @Size(min = 3, max = 100)
    private String name;

    public CategoryEntryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
