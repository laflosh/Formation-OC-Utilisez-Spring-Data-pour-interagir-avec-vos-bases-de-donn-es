package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts(){
		
		return productRepository.findAll();
		
	}
	
	public Optional<Product> getProduct(int id) {
		
		return productRepository.findById(id);
		
	}
	
}
