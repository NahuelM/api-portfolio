package com.own.api.service.Implementation;

import com.own.api.dto.Entry.ProductEntryDTO;
import com.own.api.dto.Modify.ProductModifyDTO;
import com.own.api.dto.Out.ProductOutDTO;
import com.own.api.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    @Override
    public List<ProductOutDTO> list() {
        return null;
    }

    @Override
    public ProductOutDTO register(ProductEntryDTO product) {
        return null;
    }

    @Override
    public ProductOutDTO searchForId(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductOutDTO update(ProductModifyDTO product) {
        return null;
    }
}
