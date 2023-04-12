package com.company.inventory.controller;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
    @Autowired
    private ICategoryService service;
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategory(){
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategorybyId(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
        ResponseEntity<CategoryResponseRest> response = service.save(category);
        return response;
    }

}
