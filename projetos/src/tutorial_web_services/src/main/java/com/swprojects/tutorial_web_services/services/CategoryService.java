package com.swprojects.tutorial_web_services.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swprojects.tutorial_web_services.entities.Category;
import com.swprojects.tutorial_web_services.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		@SuppressWarnings("null")
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
}