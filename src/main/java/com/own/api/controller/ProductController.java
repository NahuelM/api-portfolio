package com.own.api.controller;

import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Entry.ProductEntryDTO;
import com.own.api.dto.Modify.CategoryModifyDTO;
import com.own.api.dto.Modify.ProductModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;
import com.own.api.dto.Out.ProductOutDTO;
import com.own.api.service.ICategoryService;
import com.own.api.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<ProductOutDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutDTO> getProductForId(@PathVariable Long id){
        return new ResponseEntity<>(productService.searchForId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductOutDTO> putProduct(@RequestBody ProductModifyDTO product){
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductOutDTO> postProduct(@RequestBody ProductEntryDTO product){
        return new ResponseEntity<>(productService.register(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>("Product with id " + id + " eliminated", HttpStatus.NO_CONTENT);
    }

}
