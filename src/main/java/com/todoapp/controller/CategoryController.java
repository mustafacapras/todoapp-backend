package com.todoapp.controller;

import com.todoapp.dto.CategoryRequest;
import com.todoapp.model.Category;
import com.todoapp.security.UserPrincipal;
import com.todoapp.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(
            @Valid @RequestBody CategoryRequest categoryRequest,
            @AuthenticationPrincipal UserPrincipal currentUser) {
        return ResponseEntity.ok(categoryService.createCategory(categoryRequest, currentUser.getId()));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long categoryId,
            @Valid @RequestBody CategoryRequest categoryRequest,
            @AuthenticationPrincipal UserPrincipal currentUser) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, categoryRequest, currentUser.getId()));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(
            @PathVariable Long categoryId,
            @AuthenticationPrincipal UserPrincipal currentUser) {
        categoryService.deleteCategory(categoryId, currentUser.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(
            @PathVariable Long categoryId,
            @AuthenticationPrincipal UserPrincipal currentUser) {
        return ResponseEntity.ok(categoryService.getCategory(categoryId, currentUser.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(
            @AuthenticationPrincipal UserPrincipal currentUser) {
        return ResponseEntity.ok(categoryService.getAllCategories(currentUser.getId()));
    }
} 