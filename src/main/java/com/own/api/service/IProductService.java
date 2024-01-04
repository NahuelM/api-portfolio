package com.own.api.service;

import com.own.api.dto.Entry.ProductEntryDTO;
import com.own.api.dto.Modify.ProductModifyDTO;
import com.own.api.dto.Out.ProductOutDTO;

import java.util.List;

public interface IProductService {

    List<ProductOutDTO> list();

    ProductOutDTO register(ProductEntryDTO product);

    ProductOutDTO searchForId(Long id);

    void delete(Long id);

    ProductOutDTO update(ProductModifyDTO product);
}
