package com.openclassrooms.dataLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import com.openclassrooms.dataLayer.service.ProductService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;
	
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception{
	
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Category newCategory = new Category();
		newCategory.setName("Promotion");
		
		newCategory = categoryService.addCategory(newCategory);
		
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Product newProduct = new Product();
		newProduct.setName("AssuranceAuTiersFidelite");
		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
		newProduct.setCost(1100);
		
		newCategory.addProduct(newProduct);
		
		newProduct = productService.addProduct(newProduct);
		
		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		Comment newComment = new Comment();
		newComment.setContent("Assurance extraordinaire!");
		newProduct.addComment(newComment);

		commentService.addComment(newComment);	
		
	}

}
