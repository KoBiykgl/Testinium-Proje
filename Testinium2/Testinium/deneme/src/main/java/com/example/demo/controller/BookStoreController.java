package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.dto.request.AddBookRequest;
import com.example.demo.dto.request.BookStoreRequest;
import com.example.demo.dto.response.AddBookResponse;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.dto.response.BookStoreResponse;
import com.example.demo.service.BookStoreService;
import com.example.demo.service.manager.BookManager;
import com.example.demo.service.manager.BookStoreManager;

@RestController
@RequestScope
@RequestMapping("/bookStore")
public class BookStoreController {

	private BookStoreService bookStoreService;

	

	public BookStoreController(BookStoreService bookStoreService) {
		super();
		this.bookStoreService = bookStoreService;
	}

	@GetMapping
	public List<BookStoreResponse> getAll() {

		return bookStoreService.findAll();
	}
	
	@GetMapping("{id}")
	public BookStoreResponse getBookStoreById(@PathVariable Long id) {
		return bookStoreService.findById(id);
	}
	
	@PostMapping
	public BookStoreResponse addBookStore(
		@RequestBody  BookStoreRequest request) {
		return bookStoreService.createBook(request);
	}
	
}
