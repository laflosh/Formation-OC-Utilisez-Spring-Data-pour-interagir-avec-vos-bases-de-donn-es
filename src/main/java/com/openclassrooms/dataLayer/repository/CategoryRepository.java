package com.openclassrooms.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.dataLayer.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
