package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public Iterable<Category> getCategories(){
		
		return categoryRepository.findAll();
		
	}
	
	public Optional<Category> getCategory(int id){
		
		return categoryRepository.findById(id);
		
	}
	
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category);
		
	}
	
}
