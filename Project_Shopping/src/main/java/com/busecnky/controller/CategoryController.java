package com.busecnky.controller;

import com.busecnky.entity.Category;
import com.busecnky.service.CategoryService;
import com.busecnky.utils.BAUtils;

public class CategoryController {
	
	CategoryService categoryService;
	
	public CategoryController() {
		categoryService = new CategoryService();
	}
	

	public void create() {
		String name = BAUtils.readString("Please enter category name: ");
		
		Category category = new Category(name);
		
		categoryService.create(category);
		
	}

}
