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
	public void run(String... args) throws Exception{
	
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		
		Optional<Product> optProduct = productService.getProduct(1);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());
		
		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getName()));
		
		Optional<Comment> optComment = commentService.getComment(1);
		Comment CommentId1 = optComment.get();
		System.out.println(CommentId1.getName());
		
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		
		Optional<Category> optCategory = categoryService.getCategory(1);
		Category categoryId1 = optCategory.get();
		System.out.println(categoryId1.getName());
	}

}
