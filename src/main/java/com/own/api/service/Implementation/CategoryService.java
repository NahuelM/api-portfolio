package com.own.api.service.Implementation;

import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Modify.CategoryModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;
import com.own.api.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    @Override
    public List<CategoryOutDTO> list() {
        return null;
    }

    @Override
    public CategoryOutDTO register(CategoryEntryDTO product) {
        return null;
    }

    @Override
    public CategoryOutDTO searchForId(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CategoryOutDTO update(CategoryModifyDTO product) {
        return null;
    }
}
