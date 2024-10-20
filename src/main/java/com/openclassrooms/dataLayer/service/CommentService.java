package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public Iterable<Comment> getComments(){
		
		return commentRepository.findAll();
		
	}
	
	public Optional<Comment> getComment(int id){
		
		return commentRepository.findById(id);
		
	}
	
}
