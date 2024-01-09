package com.own.api.controller;

import com.own.api.dto.Entry.CategoryEntryDTO;
import com.own.api.dto.Modify.CategoryModifyDTO;
import com.own.api.dto.Out.CategoryOutDTO;
import com.own.api.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Controller
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryOutDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOutDTO> getCategoryForId(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.searchForId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryOutDTO> putCategory(@RequestBody CategoryModifyDTO category){
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryOutDTO> postCategory(@RequestBody CategoryEntryDTO category){
        return new ResponseEntity<>(categoryService.register(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>("Category with id " + id + " eliminated", HttpStatus.NO_CONTENT);
    }


}
