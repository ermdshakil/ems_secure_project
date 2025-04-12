package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.CategoryDto;








public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
	void deleteCategory(Long categoryId);
	CategoryDto getCategoryById(Long categoryId);
	List<CategoryDto> getAllCategory();
	public Long countCategory();

}
