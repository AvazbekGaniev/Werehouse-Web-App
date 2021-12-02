package com.example.warehouse.controller;

import com.example.warehouse.payload.ApiResponse;
import com.example.warehouse.payload.CategoryDTO;
import com.example.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public HttpEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        ApiResponse response = categoryService.save(categoryDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @GetMapping("/all")
    public HttpEntity<?> allCategory() {
        ApiResponse all = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping("/allByParent/{id}")
    public HttpEntity<?> childCategories(@PathVariable Integer id) {
        ApiResponse allChilds = categoryService.getChildCategories(id);
        return ResponseEntity.status(HttpStatus.OK).body(allChilds);
    }

    @GetMapping("/one/{id}")
    public HttpEntity<?> getOneCategory(@PathVariable Integer id) {
        ApiResponse oneById = categoryService.getOneById(id);
        return ResponseEntity.ok(oneById);
    }


    @DeleteMapping(value = "/{id}")
    public HttpEntity<?> deleteCategory(@PathVariable Integer id) {
        ApiResponse delete = categoryService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? 200 : 409).body(delete);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
        ApiResponse edited = categoryService.edit(id, categoryDTO);
        return ResponseEntity.status(edited.isSuccess() ? 200 : 409).body(edited);
    }


}
