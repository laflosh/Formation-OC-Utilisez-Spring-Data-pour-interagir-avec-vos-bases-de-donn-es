package com.openclassrooms.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.dataLayer.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
