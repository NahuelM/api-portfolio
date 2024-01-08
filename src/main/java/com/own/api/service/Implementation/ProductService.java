package com.own.api.service.Implementation;

import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Entry.ProductEntryDTO;
import com.own.api.dto.Modify.ProductModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;
import com.own.api.dto.Out.ProductOutDTO;
import com.own.api.model.Category;
import com.own.api.model.Product;
import com.own.api.repository.ProductRepository;
import com.own.api.service.IProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductOutDTO> list() {
        List<ProductOutDTO> products = productRepository.findAll().stream()
                .map(c -> modelMapper.map(c, ProductOutDTO.class)).toList();

        LOGGER.info("list of all products: {}", products);
        return products;
    }

    @Override
    public ProductOutDTO register(ProductEntryDTO product) {
        Product productSaved = productRepository.save(dtoInToEntity(product));
        ProductOutDTO productOutDTO = modelMapper.map(productSaved, ProductOutDTO.class);
        LOGGER.info("Category Saved: {}", productOutDTO);
        return productOutDTO;
    }

    @Override
    public ProductOutDTO searchForId(Long id) {
        Product productSearched = productRepository.findById(id).orElse(null);
        ProductOutDTO productOutDTO = null;
        if(productSearched != null){
            productOutDTO = modelMapper.map(productSearched, ProductOutDTO.class);
            LOGGER.info("Product: {}", productOutDTO);
        }
        else
            LOGGER.error("id not valid for product");
        return productOutDTO;
    }

    @Override
    public void delete(Long id) {
        if (searchForId(id) != null) {
            productRepository.deleteById(id);
            LOGGER.warn("eliminated product with id: {}", id);
        }
        else {
            LOGGER.error("product not found {}", id);
        }
    }

    @Override
    public ProductOutDTO update(ProductModifyDTO product) {
        Product productRecibed = modelMapper.map(product, Product.class);
        productRepository.findById(product.getId()).orElse(null);
        Product productToUpdate;
        ProductOutDTO productOutDTO = null;

        if (productRecibed != null) {

            productToUpdate = productRecibed;
            productRepository.save(productToUpdate);

            productOutDTO = modelMapper.map(productToUpdate, ProductOutDTO.class);

            LOGGER.warn("product updated: {}", productOutDTO);

        } else {
            LOGGER.error("product not registered");

        }
        return productOutDTO;
    }

    private Product dtoInToEntity(ProductEntryDTO productEntryDTO) {
        return modelMapper.map(productEntryDTO, Product.class);
    }
}
