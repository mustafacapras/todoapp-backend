package com.todoapp.service;

import com.todoapp.dto.CategoryRequest;
import com.todoapp.model.Category;
import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryRequest categoryRequest, Long userId);
    Category updateCategory(Long categoryId, CategoryRequest categoryRequest, Long userId);
    void deleteCategory(Long categoryId, Long userId);
    Category getCategory(Long categoryId, Long userId);
    List<Category> getAllCategories(Long userId);
} 