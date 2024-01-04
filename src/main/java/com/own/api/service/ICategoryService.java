package com.own.api.service;


import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Modify.CategoryModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;


import java.util.List;

public interface ICategoryService {

    List<CategoryOutDTO> list();

    CategoryOutDTO register(CategoryEntryDTO product);

    CategoryOutDTO searchForId(Long id);

    void delete(Long id);

    CategoryOutDTO update(CategoryModifyDTO product);
}
